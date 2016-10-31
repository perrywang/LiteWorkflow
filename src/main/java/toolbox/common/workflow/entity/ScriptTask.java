package toolbox.common.workflow.entity;

import javax.persistence.Entity;
import javax.script.ScriptEngine;

import lombok.Data;
import lombok.EqualsAndHashCode;
import toolbox.common.workflow.core.ExecutionContext;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class ScriptTask extends Task {
    
    private static final long serialVersionUID = -7901249111185155944L;
    
    private String scripts;
        
    public ScriptTask(Long id) {
        super(id);
    }

    @Override
    public boolean execute(ExecutionContext context) {
        ScriptEngine scriptEngine = context.getScriptEngine();
        scriptEngine.put("record",context.getActiveRecord());
        try{
            scriptEngine.eval(scripts);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
