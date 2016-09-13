package toolbox.common.workflow.core;

public interface WorkflowPhase extends Describable {
    
    void addAction(WorkflowAction action, ActionLifecycle lifecycle, boolean isAsync);
}
