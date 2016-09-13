package toolbox.common.workflow.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import toolbox.common.workflow.engine.WorkflowExecution;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Entity
public class ExecutionEntity extends Persistable implements WorkflowExecution {

    private static final long serialVersionUID = -1214145175194494791L;
    
    @ManyToOne
    private PhaseEntity currentPhase;
    
    @ManyToOne
    private WorkflowEntity workflow;
    
    public ExecutionEntity(Long id) {
        super(id);
    }
    
    public ExecutionEntity(WorkflowEntity workflow) {
        this.workflow = workflow;
    }
    
}
