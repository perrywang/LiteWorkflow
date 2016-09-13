package toolbox.common.workflow.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import toolbox.common.workflow.core.ActionLifecycle;
import toolbox.common.workflow.core.WorkflowAction;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Entity
public class ActionEntity extends DescribableEntity implements WorkflowAction {
     
    private static final long serialVersionUID = -7694501520719761660L;
    
    @ManyToOne
    private WorkflowEntity workflow;
    
    @ManyToOne
    private PhaseEntity phase;
    
    private ActionLifecycle lifecycle;
    
    private boolean isAsync = false;
    
    public ActionEntity(Long id) {
        super(id);
    }
    
    public ActionEntity(String name, String description) {
        super(name,description);
    }

}
