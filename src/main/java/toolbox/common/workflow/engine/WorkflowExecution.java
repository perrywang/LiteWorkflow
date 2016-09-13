package toolbox.common.workflow.engine;

import toolbox.common.workflow.core.WorkflowPhase;

public interface WorkflowExecution {
   
    WorkflowPhase getCurrentPhase();
}
