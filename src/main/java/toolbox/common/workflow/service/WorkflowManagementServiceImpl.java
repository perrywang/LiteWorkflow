package toolbox.common.workflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toolbox.common.workflow.core.TaskExecutionLifecycle;
import toolbox.common.workflow.entity.Phase;
import toolbox.common.workflow.entity.Task;
import toolbox.common.workflow.entity.TaskBinding;
import toolbox.common.workflow.entity.Transition;
import toolbox.common.workflow.entity.TransitionType;
import toolbox.common.workflow.entity.Workflow;
import toolbox.common.workflow.repository.PhaseRepository;
import toolbox.common.workflow.repository.TaskBindingRepository;
import toolbox.common.workflow.repository.TransitionRepository;
import toolbox.common.workflow.repository.WorkflowRepository;

@Service
public class WorkflowManagementServiceImpl implements WorkflowManagementService {
    
    @Autowired
    private WorkflowRepository workflowRepo;
    
    @Autowired
    private PhaseRepository phaseRepo;
    
    @Autowired
    private TransitionRepository transitionRepository;
    
    @Autowired
    private TaskBindingRepository bindingRepository;
    
    @Override
    public Workflow createWorkflow(String name, String description) {
        Workflow workflow = new Workflow();
        workflow.setName(name);
        workflow.setDescription(description);
        return workflowRepo.save(workflow);
    }

    @Override
    public Phase addPhaseToWorkflow(Workflow workflow, String phaseName, String phaseDescription, boolean isStart) {
        Phase phase = workflow.addPhase(phaseName, phaseDescription,isStart);
        return phaseRepo.save(phase);
    }

    @Override
    public Transition addTransitionToWorkflow(Workflow workflow, Phase from, Phase to, TransitionType type,
            String conditionExpression) {
        Transition transition = workflow.addTransition(from, to, type, conditionExpression);
        return transitionRepository.save(transition);
    }

    @Override
    public void bindTaskToWorkflow(Workflow workflow, Task task, TaskExecutionLifecycle lifecycle, boolean isAsync) {
        
        TaskBinding binding = workflow.addTask(task, lifecycle, isAsync);
        bindingRepository.save(binding);
    }

    @Override
    public void bindTaskToPhase(Phase phase, Task task, TaskExecutionLifecycle lifecycle, boolean isAsync) {
        TaskBinding binding = phase.addTask(task, lifecycle, isAsync);
        bindingRepository.save(binding);
    }

    @Override
    public void unbindTask(Long bindingId) {
        bindingRepository.delete(bindingId);
    }
}
