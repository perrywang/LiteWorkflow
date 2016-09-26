package toolbox.common.workflow.entity;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import toolbox.common.workflow.engine.ExecutionContext;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class ScriptTask extends TaskEntity {
    
    private static final long serialVersionUID = -7901249111185155944L;
    
    private String scripts;
        
    public ScriptTask(String name, String description) {
        super(name, description);
    }

    @Override
    public boolean execute(ExecutionContext context) {
        return false;
    }

}
