package toolbox.common.workflow.core;

import toolbox.common.workflow.engine.ExecutionContext;

public interface WorkflowAction extends Describable {
    
    default void execute(ExecutionContext context) {};

}
