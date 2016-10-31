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
public class Phase extends Persistable {

    private static final long serialVersionUID = -1123518726422072368L;
    
    private String name;
    
    private String description;
    
    private boolean isStart = false;
    
    @ManyToOne
    private Workflow workflow;
    
    public Phase(Long id) {
        super(id);
    }

    public TaskBinding addTask(Task task, TaskExecutionLifecycle lifecycle, boolean isAsync) {
        TaskBinding taskBinding = new TaskBinding();
        taskBinding.setTask(task);
        taskBinding.setLifecycle(lifecycle);
        taskBinding.setAsync(isAsync);
        taskBinding.setPhase(this);
        return taskBinding;
    }

}
