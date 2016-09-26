package toolbox.common.workflow.engine;

import toolbox.common.workflow.core.Workflow;
import toolbox.common.workflow.core.WorkflowAction;
import toolbox.common.workflow.core.WorkflowTransition;

public interface ExecutionEngine {
    
    void startWorkflow(Workflow workflow, ExecutionContext context);
    
    void doTransition(WorkflowExecution execution, WorkflowTransition transition, ExecutionContext context);
    
    void doAction(WorkflowExecution execution, WorkflowAction action, ExecutionContext context);

}
