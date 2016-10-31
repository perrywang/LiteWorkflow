package toolbox.common.workflow.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import lombok.Data;
import lombok.NoArgsConstructor;
import toolbox.common.workflow.engine.scripting.ActiveRecord;
import toolbox.common.workflow.engine.scripting.ScriptEngineFactory;
import toolbox.common.workflow.entity.Execution;

@Data
@NoArgsConstructor
public class SimpleExecutionContext implements ExecutionContext {
    
    private Execution execution;
    
    private ExecutionContext parentContext;
    
    private ScriptEngine scriptEngine;
    
    private ActiveRecord record;
    
    private Map<String, Object> properties = new HashMap<>();

    public SimpleExecutionContext(ExecutionContext parent, Execution execution, ActiveRecord record) {
        this.parentContext = parent;
        this.execution = execution;
        this.record = record;
        this.scriptEngine = ScriptEngineFactory.createEngine();
    }
    
    public SimpleExecutionContext(ExecutionContext parent, Execution execution) {
        this(parent,execution,new ActiveRecord());
    }

    @Override
    public ActiveRecord getActiveRecord() {
        return record;
    }

    @Override
    public void setProperty(String key, Object value) {
        properties.put(key, value);
        
    }

    @Override
    public Object getProperty(String key) {
        return properties.get(key);
    }

    @Override
    public Set<String> getPropertyNames() {
       return properties.keySet();
    }

    @Override
    public boolean evaluateCondition(String condition) {
        // TODO Auto-generated method stub
        try {
            return (boolean)scriptEngine.eval(condition);
        } catch (ScriptException e) {
            e.printStackTrace();
            return false;
        }
    }
}
