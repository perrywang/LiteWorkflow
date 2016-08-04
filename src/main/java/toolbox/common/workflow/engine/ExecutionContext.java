package toolbox.common.workflow.engine;

import com.hpe.sm.workflow.entity.WorkflowExecution;

public interface ExecutionContext<T> {
    
    T getDocument();
    
    void setDocument(T document);
    
    WorkflowExecution getExecution();
    
    void setExecution(WorkflowExecution execution);
    
    void put(String key, Object value);
    
    Object get(String key);
}
