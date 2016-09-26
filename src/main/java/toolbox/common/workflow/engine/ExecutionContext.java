package toolbox.common.workflow.engine;

import javax.script.ScriptEngine;

import toolbox.common.workflow.engine.scripting.ActiveRecord;

public interface ExecutionContext {
    
    ActiveRecord getActiveRecord();
    
    ExecutionContext getParentContext();
    
    ScriptEngine getScriptEngine();
    
    WorkflowExecution getExecution();
    
    void setExecution(WorkflowExecution execution);
    
    void put(String key, Object value);
    
    Object get(String key);
}
