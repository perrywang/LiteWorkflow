package toolbox.common.workflow.entity;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import toolbox.common.workflow.core.TaskExecutionLifecycle;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Entity
public class Workflow extends Persistable {
    
    private static final long serialVersionUID = -4664710822540762790L;
    
    private String name;
    
    private String description;
    
    public Workflow(Long id) {
        super(id);
    }

    public Phase addPhase(String name, String description, boolean isStart) {
        Phase phase = new Phase();
        phase.setName(name);
        phase.setDescription(description);
        phase.setStart(isStart);
        phase.setWorkflow(this);
        return phase;
    }

    public TaskBinding addTask(Task task, TaskExecutionLifecycle lifecycle, boolean isAsync) {
        TaskBinding taskBinding = new TaskBinding();
        taskBinding.setTask(task);
        taskBinding.setLifecycle(lifecycle);
        taskBinding.setAsync(isAsync);
        taskBinding.setWorkflow(this);
        return taskBinding;
    }

    public Transition addTransition(Phase from, Phase to, TransitionType type, String condition) {
        
        assert this.equals(from.getWorkflow());
        assert this.equals(to.getWorkflow());
        Transition transition = new Transition();
        transition.setFrom(from);
        transition.setTo(to);
        transition.setWorkflow(this);
        transition.setConditionExpression(condition);
        return transition;
    }

}
