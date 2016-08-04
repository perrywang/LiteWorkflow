package toolbox.common.workflow.event;

import java.time.ZonedDateTime;

import lombok.Data;
import toolbox.common.workflow.engine.ExecutionContext;

@Data
public class WorkflowEvent implements Event {

    private ZonedDateTime occuredOn = ZonedDateTime.now();
    
    private EventBus eventBus;
    
    @SuppressWarnings("rawtypes")
    private ExecutionContext context;
    
    @Override
    public ZonedDateTime occuredOn() {

        return occuredOn;
    }

}
