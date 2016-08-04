package toolbox.common.workflow.core;

public interface WorkflowTransition extends WorkflowAction{
    
    WorkflowPhase getFrom();
    
    WorkflowPhase getTo();
    
    TransitionCondition getCondition();
    
}
