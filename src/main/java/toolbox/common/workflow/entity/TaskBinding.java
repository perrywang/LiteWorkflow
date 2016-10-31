package toolbox.common.workflow.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import toolbox.common.workflow.core.TaskExecutionLifecycle;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Entity
public class TaskBinding extends Persistable {
     
    private static final long serialVersionUID = -7694501520719761660L;
    
    @ManyToOne
    private Workflow workflow;
    
    @ManyToOne
    private Phase phase;
    
    @ManyToOne
    private Task task;
    
    private TaskExecutionLifecycle lifecycle;
    
    private boolean isAsync = false;
    
    public TaskBinding(Long id) {
        super(id);
    }

}
