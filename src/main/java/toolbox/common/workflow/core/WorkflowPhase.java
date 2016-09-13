package toolbox.common.workflow.core;

public interface WorkflowPhase extends Describable {
    
    Workflow getWorkflow();
    
    void addAction(WorkflowAction action, ActionLifecycle lifecycle, boolean isAsync);
}
