package toolbox.common.workflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import toolbox.common.workflow.core.ExecutionContext;
import toolbox.common.workflow.entity.Execution;
import toolbox.common.workflow.entity.Phase;
import toolbox.common.workflow.entity.Transition;
import toolbox.common.workflow.entity.Workflow;
import toolbox.common.workflow.event.TransitingStartingEvent;
import toolbox.common.workflow.event.WorkflowStartingEvent;
import toolbox.common.workflow.repository.ExecutionRepository;

@Service
public class ExecutionServiceImpl implements ExecutionService{
    
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    
    @Autowired
    private ExecutionRepository executionRepository;

    @Override
    public Execution startWorkflow(Workflow workflow, ExecutionContext context) {
        WorkflowStartingEvent event = new WorkflowStartingEvent(context, workflow);
        eventPublisher.publishEvent(event);
        return context.getExecution();
    }

    @Override
    public void doTransition(Execution execution, Transition transition, ExecutionContext context) {
        TransitingStartingEvent event = new TransitingStartingEvent(context, transition.getFrom(), transition.getTo());
        eventPublisher.publishEvent(event);
    }
    
    @Override
    public void forceToPhase(Execution execution, Phase phase) {
        execution.setCurrentPhase(phase);
        executionRepository.save(execution);
    }

}
