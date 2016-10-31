package toolbox.common.workflow.entity;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import toolbox.common.workflow.core.ExecutionContext;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public abstract class Task extends Persistable {

    private static final long serialVersionUID = -185560353789676753L;
    
    private String name;
    
    private String description;
    
    public Task(Long id) {
        super(id);
    }
    
    public abstract boolean execute(ExecutionContext context);

}
