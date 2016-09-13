package toolbox.common.workflow.engine;

import toolbox.common.workflow.core.Workflow;
import toolbox.common.workflow.core.WorkflowPhase;

public interface WorkflowExecution {
   
    WorkflowPhase getCurrentPhase();
    
    default Workflow getWorkflow() {
        return getCurrentPhase().getWorkflow();
    }
}
