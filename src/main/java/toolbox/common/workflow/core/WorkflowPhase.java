package toolbox.common.workflow.core;

import java.util.List;

public interface WorkflowPhase extends Describable {
    
    List<WorkflowAction> getActions(ActionLifecycle lifecycle);
    
    void addAction(WorkflowAction action, ActionLifecycle lifecycle, boolean isAsync);
}
