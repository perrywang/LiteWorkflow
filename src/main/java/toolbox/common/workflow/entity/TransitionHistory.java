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
public class TransitionHistory extends Persistable {
    
    private static final long serialVersionUID = -9000688488370793449L;
    
    @ManyToOne
    private Execution execution;

    @ManyToOne
    private Phase from;

    @ManyToOne
    private Phase to;
}
