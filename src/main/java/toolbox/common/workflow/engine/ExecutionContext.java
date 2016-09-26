package toolbox.common.workflow.engine;

import javax.script.ScriptEngine;

public interface ExecutionContext<T> {
    
    T getData();
    
    ScriptEngine getScriptEngine();
    
    WorkflowExecution getExecution();
    
    void setExecution(WorkflowExecution execution);
    
    void put(String key, Object value);
    
    Object get(String key);
}
