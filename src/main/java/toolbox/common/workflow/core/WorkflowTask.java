package toolbox.common.workflow.core;

import toolbox.common.workflow.engine.ExecutionContext;

public interface WorkflowTask {
    
    boolean execute(ExecutionContext context);

}
