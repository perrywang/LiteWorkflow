package toolbox.common.workflow.engine;

import javax.script.ScriptEngine;

public interface ExecutionContext<T> {
    
    T getDocument();
    
    void setDocument(T document);
    
    ScriptEngine getScriptEngine();
    
    WorkflowExecution getExecution();
    
    void setExecution(WorkflowExecution execution);
    
    void put(String key, Object value);
    
    Object get(String key);
}
