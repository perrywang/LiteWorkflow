package toolbox.common.workflow.core;

import toolbox.common.workflow.engine.ExecutionContext;

public interface WorkflowAction {
    
    String getName();
    
    String getDescription();
    
    <T> void execute(ExecutionContext<T> context);
}
