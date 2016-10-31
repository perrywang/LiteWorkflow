package toolbox.common.workflow.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import toolbox.common.workflow.core.ExecutionContext;
import toolbox.common.workflow.entity.Phase;

@Data
@EqualsAndHashCode(callSuper=false)
public class TransitingStartingEvent extends AbstractWorkflowEvent{
    
    private Phase from;
    
    private Phase to;
    
    public TransitingStartingEvent(ExecutionContext context, Phase from, Phase to) {
        super(context);
        this.from = from;
        this.to = to;
    }
}
