package toolbox.common.workflow.core;

import javax.script.ScriptEngine;

import toolbox.common.workflow.engine.scripting.ActiveRecord;
import toolbox.common.workflow.entity.Execution;

public interface ExecutionContext extends Context {
    
    ActiveRecord getActiveRecord();
    
    ExecutionContext getParentContext();
    
    ScriptEngine getScriptEngine();
    
    Execution getExecution();
    
    void setExecution(Execution execution);
    
    boolean evaluateCondition(String condition);
    
}
