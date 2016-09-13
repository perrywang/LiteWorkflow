package toolbox.common.workflow.core;

public interface WorkflowTransition extends Describable {
    
    TransitionCondition getCondition();
    
    WorkflowPhase getFrom();
    
    WorkflowPhase getTo();
    
}
