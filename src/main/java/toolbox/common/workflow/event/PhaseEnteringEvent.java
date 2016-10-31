package toolbox.common.workflow.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import toolbox.common.workflow.core.ExecutionContext;
import toolbox.common.workflow.entity.Phase;

@Data
@EqualsAndHashCode(callSuper=false)
public class PhaseEnteringEvent extends AbstractWorkflowEvent {
    
    private Phase enteringPhase;
    
    public PhaseEnteringEvent(ExecutionContext context, Phase enteringPhase) {
        super(context);
        this.enteringPhase = enteringPhase;
    }
    
}
