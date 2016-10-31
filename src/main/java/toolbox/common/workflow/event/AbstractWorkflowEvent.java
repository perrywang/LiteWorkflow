package toolbox.common.workflow.event;

import java.time.ZonedDateTime;

import lombok.Data;
import toolbox.common.workflow.core.ExecutionContext;

@Data
public abstract class AbstractWorkflowEvent implements Event {

    private ZonedDateTime occuredOn = ZonedDateTime.now();
    
    private ExecutionContext context;
    
    @Override
    public ZonedDateTime occuredOn() {
        return occuredOn;
    }
    
    public AbstractWorkflowEvent(ExecutionContext context) {
        this.context = context;
    }

}
