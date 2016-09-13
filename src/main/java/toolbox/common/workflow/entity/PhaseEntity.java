package toolbox.common.workflow.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import toolbox.common.workflow.core.ActionLifecycle;
import toolbox.common.workflow.core.WorkflowAction;
import toolbox.common.workflow.core.WorkflowPhase;
import toolbox.common.workflow.repository.RepositoryRegistry;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Entity
public class PhaseEntity extends DescribableEntity implements WorkflowPhase {

    private static final long serialVersionUID = -1123518726422072368L;
    
    @ManyToOne
    private WorkflowEntity workflow;
    
    public PhaseEntity(Long id) {
        super(id);
    }

    @Override
    public List<WorkflowAction> getActions(ActionLifecycle lifecycle) {
        return RepositoryRegistry.instance().getActionRepository().findByPhaseAndLifecycle(this, lifecycle);
    }

    @Override
    public void addAction(WorkflowAction action, ActionLifecycle lifecycle, boolean isAsync) {
        ActionEntity actionEntity = (ActionEntity)action;
        actionEntity.setLifecycle(lifecycle);
        actionEntity.setAsync(isAsync);
        RepositoryRegistry.instance().getActionRepository().save(actionEntity); 
    }

}
