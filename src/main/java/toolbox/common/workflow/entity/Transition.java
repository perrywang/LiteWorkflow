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
public class Transition extends Persistable { 
    
    private static final long serialVersionUID = -852009937863296827L;
    
    @ManyToOne
    private Phase from;
    
    @ManyToOne
    private Phase to;
    
    @ManyToOne
    private Workflow workflow;
    
    private String conditionExpression;
    
    public Transition(Long id) {
        super(id);
    }

}
