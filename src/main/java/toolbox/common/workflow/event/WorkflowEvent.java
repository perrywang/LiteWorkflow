package toolbox.common.workflow.event;

import java.time.ZonedDateTime;

import lombok.Data;
import toolbox.common.workflow.engine.ExecutionContext;

@Data
public abstract class WorkflowEvent implements Event {

    private ZonedDateTime occuredOn = ZonedDateTime.now();
    
    private ExecutionContext context;
    
    @Override
    public ZonedDateTime occuredOn() {
        return occuredOn;
    }
    
    public WorkflowEvent(ExecutionContext context) {
        this.context = context;
    }

}
