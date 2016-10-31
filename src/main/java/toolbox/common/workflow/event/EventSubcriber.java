package toolbox.common.workflow.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import toolbox.common.workflow.core.ExecutionContext;
import toolbox.common.workflow.core.TaskExecutionLifecycle;
import toolbox.common.workflow.entity.Execution;
import toolbox.common.workflow.entity.Phase;
import toolbox.common.workflow.entity.TaskBinding;
import toolbox.common.workflow.entity.Transition;
import toolbox.common.workflow.entity.TransitionHistory;
import toolbox.common.workflow.repository.PhaseRepository;
import toolbox.common.workflow.repository.RepositoryRegistry;
import toolbox.common.workflow.repository.TaskBindingRepository;
import toolbox.common.workflow.repository.TransitionRepository;

@Service
public class EventSubcriber {
    
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    
    @Autowired
    private PhaseRepository phaseRepository;
    
    @Autowired
    private TaskBindingRepository taskBindingRepository;
    
    @Autowired
    private TransitionRepository transitionRepository;
    
    @EventListener
    public void onWorkflowStart(WorkflowStartingEvent event) {
        
        ExecutionContext context = event.getContext();
        
        List<TaskBinding> taskBindings = taskBindingRepository.findByWorkflowAndLifecycle(event.getWorkflow(), TaskExecutionLifecycle.WorkflowStarting);
        for(TaskBinding binding : taskBindings) {
            binding.getTask().execute(event.getContext());
        }
        
        Phase startPhase = phaseRepository.findByWorkflowAndIsStart(event.getWorkflow(), true);
        
        PhaseEnteringEvent phaseEnteringEvent = new PhaseEnteringEvent(context,startPhase);
        
        eventPublisher.publishEvent(phaseEnteringEvent);
    }
    
    @EventListener
    public void onPhaseEntering(PhaseEnteringEvent event) {
        ExecutionContext context = event.getContext();
        Execution execution = context.getExecution();
        Phase phase = event.getEnteringPhase();
        execution.setCurrentPhase(phase);
        context.setExecution(RepositoryRegistry.instance().getExecutionRepository().save(execution));
        List<TaskBinding> taskBindings = taskBindingRepository.findByPhaseAndLifecycle(phase,TaskExecutionLifecycle.PhaseEnerting);
        for(TaskBinding binding : taskBindings) {
            binding.getTask().execute(context);
        }
        
        List<Transition> transitions = transitionRepository.findByFrom(phase);
        
        for(Transition transition: transitions){
            if(context.evaluateCondition(transition.getConditionExpression())){
                TransitingStartingEvent transitingEvent = new TransitingStartingEvent(context,transition.getFrom(),transition.getTo());
                eventPublisher.publishEvent(transitingEvent);
            }
        }
    }
    
    @EventListener
    public void onPhaseLeft(PhaseLeftEvent event) {
        ExecutionContext context = event.getContext();
        Phase phase = event.getLeftPhase();
        List<TaskBinding> taskBindings = taskBindingRepository.findByPhaseAndLifecycle(phase,TaskExecutionLifecycle.PhaseLeft);
        for(TaskBinding binding : taskBindings) {
            binding.getTask().execute(context);
        }
    }
    
    @EventListener
    public void onTransitingStarting(TransitingStartingEvent event) {
        ExecutionContext context = event.getContext();
        Execution execution = context.getExecution();
        Phase from = event.getFrom();
        Phase to = event.getTo();
        PhaseLeftEvent phaseLeftEvent = new PhaseLeftEvent(context,from);
        eventPublisher.publishEvent(phaseLeftEvent);
        PhaseEnteringEvent phaseEnteringEvent = new PhaseEnteringEvent(context,to);
        eventPublisher.publishEvent(phaseEnteringEvent);
        eventPublisher.publishEvent(new TransitingFinishedEvent(execution,from,to));
    }
    
    @EventListener
    public void onTransitingFinished(TransitingFinishedEvent event) {
        Execution execution = event.getExecution();
        Phase from = event.getFrom();
        Phase to = event.getTo();
        TransitionHistory entryHistory = new TransitionHistory();
        entryHistory.setExecution(execution);
        entryHistory.setFrom(from);
        entryHistory.setTo(to);
        RepositoryRegistry.instance().getTransitionHistoryRepository().save(entryHistory);
    }
    
}
