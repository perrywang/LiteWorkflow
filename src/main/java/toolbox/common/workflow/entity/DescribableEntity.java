package toolbox.common.workflow.entity;

import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import toolbox.common.workflow.core.Describable;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@MappedSuperclass
public abstract class DescribableEntity extends Persistable implements Describable {

    private static final long serialVersionUID = 6028842347912537407L;
    
    private String name;
    
    private String description;
    
    public DescribableEntity(Long id) {
        super(id);
    }
    
    public DescribableEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
