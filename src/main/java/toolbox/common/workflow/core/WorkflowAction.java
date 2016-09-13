package toolbox.common.workflow.core;

import toolbox.common.workflow.engine.ExecutionContext;

public interface WorkflowAction extends Describable {
    
    default <T> void execute(ExecutionContext<T> context) {};

}
