package toolbox.common.workflow.core;

import toolbox.common.workflow.entity.Execution;
import toolbox.common.workflow.entity.TaskBinding;
import toolbox.common.workflow.entity.Transition;
import toolbox.common.workflow.entity.Workflow;

public interface ExecutionEngine {
    
    void startWorkflow(Workflow workflow, ExecutionContext context);
    
    void doTransition(Execution execution, Transition transition, ExecutionContext context);
    
    void doTask(Execution execution, TaskBinding task, ExecutionContext context);

}
