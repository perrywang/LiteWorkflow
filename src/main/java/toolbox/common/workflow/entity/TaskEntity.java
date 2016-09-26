package toolbox.common.workflow.entity;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import toolbox.common.workflow.core.WorkflowTask;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public abstract class TaskEntity extends DescribableEntity implements WorkflowTask {

    private static final long serialVersionUID = -185560353789676753L;
    
    public TaskEntity(String name, String description) {
        super(name,description);
    }

}
