package toolbox.common.workflow.core;

public interface Workflow {
    
    String getName();
    
    String getDescription();
    
    void addPhase();
    
    void addTransition(WorkflowTransition transition);
    
    void addTransition(WorkflowPhase from, Workflow to);
    
    void addAction(WorkflowAction action, Lifecycle lifecycle);
}
