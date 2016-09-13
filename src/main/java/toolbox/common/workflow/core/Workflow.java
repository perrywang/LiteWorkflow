package toolbox.common.workflow.core;

public interface Workflow extends Describable {
    
    WorkflowPhase addPhase(String name, String description);
    
    void addTransition(WorkflowPhase from, WorkflowPhase to, String name, String description, TransitionCondition condition);
    
    void addAction(WorkflowAction action, ActionLifecycle lifecycle, boolean isAsync);
    
}
