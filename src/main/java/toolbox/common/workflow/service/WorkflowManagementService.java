package toolbox.common.workflow.service;

import toolbox.common.workflow.core.TaskExecutionLifecycle;
import toolbox.common.workflow.entity.Phase;
import toolbox.common.workflow.entity.Task;
import toolbox.common.workflow.entity.Transition;
import toolbox.common.workflow.entity.TransitionType;
import toolbox.common.workflow.entity.Workflow;

public interface WorkflowManagementService {
    
    Workflow createWorkflow(String name, String description);
    
    Phase addPhaseToWorkflow(Workflow workflow, String phaseName, String phaseDescription, boolean isStart);
    
    default Phase addPhaseToWorkflow(Workflow workflow, String phaseName, String phaseDescription){
        return addPhaseToWorkflow(workflow, phaseName, phaseDescription, false);
    }
    
    Transition addTransitionToWorkflow(Workflow workflow, Phase from, Phase to, TransitionType type, String conditionExpression);
    
    void bindTaskToWorkflow(Workflow workflow, Task task, TaskExecutionLifecycle lifecycle, boolean isAsync);
    
    default void bindTaskToWorkflow(Workflow workflow, Task task, TaskExecutionLifecycle lifecycle){
        bindTaskToWorkflow(workflow,task,lifecycle,false);
    }
    
    void bindTaskToPhase(Phase phase, Task task, TaskExecutionLifecycle lifecycle,boolean isAsync);
    
    default void bindTaskToPhase(Phase phase, Task task, TaskExecutionLifecycle lifecycle){
        bindTaskToPhase(phase,task,lifecycle,false);
    }
    
    void unbindTask(Long bindingId);
    
}
