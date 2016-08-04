package toolbox.common.workflow.core;

import java.util.List;

public interface WorkflowPhase {
    
    String getName();
    
    String getDescription();
    
    List<WorkflowAction> getActions();
    
    void addAction();
    
    void addAction(WorkflowAction action, Lifecycle lifecycle);
}
