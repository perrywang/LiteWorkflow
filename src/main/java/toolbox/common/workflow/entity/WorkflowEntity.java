package toolbox.common.workflow.entity;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import toolbox.common.workflow.core.ActionLifecycle;
import toolbox.common.workflow.core.TransitionCondition;
import toolbox.common.workflow.core.Workflow;
import toolbox.common.workflow.core.WorkflowAction;
import toolbox.common.workflow.core.WorkflowPhase;
import toolbox.common.workflow.repository.RepositoryRegistry;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class WorkflowEntity extends DescribableEntity implements Workflow {
    
    private static final long serialVersionUID = -4664710822540762790L;
    
    public WorkflowEntity(Long id) {
        super(id);
    }

    @Override
    public WorkflowPhase addPhase(String name, String description) {
        PhaseEntity phase = new PhaseEntity();
        phase.setName(name);
        phase.setDescription(description);
        phase.setWorkflow(this);
        return RepositoryRegistry.instance().getPhaseRepo().save(phase);
    }

    @Override
    public void addAction(WorkflowAction action, ActionLifecycle lifecycle, boolean isAsync) {
        ActionEntity actionEntity = (ActionEntity)action;
        actionEntity.setLifecycle(lifecycle);
        actionEntity.setAsync(isAsync);
        actionEntity.setWorkflow(this);
        RepositoryRegistry.instance().getActionRepository().save(actionEntity);
    }

    @Override
    public void addTransition(WorkflowPhase from, WorkflowPhase to, String name, String description,
            TransitionCondition condition) {
        TransitionEntity transition = new TransitionEntity(name, description);
        transition.setFrom((PhaseEntity)from);
        transition.setTo((PhaseEntity)to);
        transition.setCondition(new TransitionConditionVO(condition.getExpression()));
        RepositoryRegistry.instance().getTransitionRepository().save(transition);
    }

}
