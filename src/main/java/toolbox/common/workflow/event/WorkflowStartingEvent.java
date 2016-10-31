package toolbox.common.workflow.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import toolbox.common.workflow.core.ExecutionContext;
import toolbox.common.workflow.entity.Workflow;

@Data
@EqualsAndHashCode(callSuper=false)
public class WorkflowStartingEvent extends AbstractWorkflowEvent {
    
    private Workflow workflow;
    
    public WorkflowStartingEvent(ExecutionContext context, Workflow starting) {
        super(context);
        this.workflow = starting;
    }
}
