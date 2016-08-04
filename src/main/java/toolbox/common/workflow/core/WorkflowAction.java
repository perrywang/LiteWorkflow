package toolbox.common.workflow.core;

import toolbox.common.workflow.engine.ExecutionContext;

public interface WorkflowAction {
    
    String getName();
    
    String getDescription();
    
    default <T> void execute(ExecutionContext<T> context) {
        execute(context, false);
    }
    
    <T> void execute(ExecutionContext<T> context, boolean asynchronize);
}
