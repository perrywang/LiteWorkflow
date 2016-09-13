package toolbox.common.workflow.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import toolbox.common.workflow.core.WorkflowTransition;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class TransitionEntity extends DescribableEntity implements WorkflowTransition { 
    
    private static final long serialVersionUID = -852009937863296827L;
    
    @ManyToOne
    private PhaseEntity from;
    
    @ManyToOne
    private PhaseEntity to;
    
    @Embedded
    private TransitionConditionVO condition;
    
    public TransitionEntity(Long id) {
        super(id);
    }
    
    public TransitionEntity(String name, String description) {
        super(name,description);
    }

}
