package toolbox.common.workflow.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import toolbox.common.workflow.core.ExecutionContext;
import toolbox.common.workflow.entity.Phase;

@Data
@EqualsAndHashCode(callSuper=false)
public class PhaseLeftEvent extends AbstractWorkflowEvent {
    
    private Phase leftPhase;
    
    public PhaseLeftEvent(ExecutionContext context, Phase leftPhase) {
        super(context);
        this.leftPhase = leftPhase;
    }
    
}

