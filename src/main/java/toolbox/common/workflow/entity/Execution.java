package toolbox.common.workflow.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Entity
public class Execution extends Persistable {

    private static final long serialVersionUID = -1214145175194494791L;
    
    @ManyToOne
    private Phase currentPhase;
    
    @ManyToOne
    private Workflow workflow;
    
    @ManyToOne
    private Execution parent;
    
    public Execution(Long id) {
        super(id);
    }
    
    public Execution(Workflow workflow) {
        this.workflow = workflow;
    }

}
