package toolbox.common.workflow.engine;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptEngine;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import toolbox.common.workflow.engine.scripting.ActiveRecord;
import toolbox.common.workflow.engine.scripting.ScriptEngineFactory;

/**
 * 
 * @author pengwang
 * Using json format as workflow active record presentation
 *
 */

@Data
@NoArgsConstructor
@Slf4j
public class SimpleExecutionContext implements ExecutionContext {
    
    private WorkflowExecution execution;
    
    private ExecutionContext parentContext;
    
    private ScriptEngine scriptEngine;
    
    private Map<String, Object> properties = new HashMap<>();

    public SimpleExecutionContext(ExecutionContext parent, WorkflowExecution execution, JsonNode context) {
        this.parentContext = parent;
        this.execution = execution;
        bindScritEngine(context);
    }
    
    public SimpleExecutionContext(ExecutionContext parent, WorkflowExecution execution) {
        this(parent,execution,null);
    }
    
    private void bindScritEngine(JsonNode context) {
        this.scriptEngine = ScriptEngineFactory.createEngine();
        if(context != null) {
            String dataJson = context.get("data").asText();
            ObjectMapper om = new ObjectMapper();
            try{
                ActiveRecord activeRecord = om.readValue(dataJson, ActiveRecord.class);
                scriptEngine.put("record", activeRecord);
            }catch(IOException e){
                log.warn("no binding for variable record");
            }
            
        }
    }

    @Override
    public ActiveRecord getActiveRecord() {
        return (ActiveRecord)scriptEngine.get("record");
    }

    @Override
    public void put(String key, Object value) {
        properties.put(key, value);
        
    }

    @Override
    public Object get(String key) {
        return properties.get(key);
    }
}
