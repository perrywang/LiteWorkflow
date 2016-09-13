package toolbox.common.workflow.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@MappedSuperclass
public abstract class Persistable implements Serializable {
    
    private static final long serialVersionUID = 590759545909320027L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
       
    public Persistable(Long id) {
        this.id = id;
    }

}
