package toolbox.common.workflow.engine;

import toolbox.common.workflow.core.Workflow;
import toolbox.common.workflow.core.WorkflowAction;
import toolbox.common.workflow.core.WorkflowTransition;

public interface ExecutionEngine {
    
    <T> void startWorkflow(Workflow workflow, ExecutionContext<T> context);
    
    <T> void doTransition(WorkflowExecution execution, WorkflowTransition transition, ExecutionContext<T> context);
    
    <T> void doAction(WorkflowExecution execution, WorkflowAction action, ExecutionContext<T> context);

}
