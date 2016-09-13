package toolbox.common.workflow.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import toolbox.common.workflow.core.Workflow;
import toolbox.common.workflow.engine.ExecutionContext;

@Data
@EqualsAndHashCode(callSuper=false)
public class WorkflowStartingEvent extends WorkflowEvent {
    
    private Workflow workflow;
    
    public WorkflowStartingEvent(ExecutionContext<?> context, Workflow starting) {
        super(context);
        this.workflow = starting;
    }
}
