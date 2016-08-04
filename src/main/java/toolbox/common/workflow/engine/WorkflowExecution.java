package toolbox.common.workflow.engine;

import toolbox.common.workflow.core.Workflow;
import toolbox.common.workflow.core.WorkflowPhase;

public interface WorkflowExecution {
    
    Workflow getWorkflow();
   
    WorkflowPhase getCurrentPhase();
    
    @SuppressWarnings("rawtypes")
    ExecutionContext getContext();
}
