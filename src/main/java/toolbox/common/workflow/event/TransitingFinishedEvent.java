package toolbox.common.workflow.event;

import lombok.Data;
import toolbox.common.workflow.entity.Execution;
import toolbox.common.workflow.entity.Phase;

@Data
public class TransitingFinishedEvent {
    
    private Execution execution;
    
    private Phase from;
    
    private Phase to;
    
    public TransitingFinishedEvent(Execution execution, Phase from, Phase to) {
        this.execution = execution;
        this.from = from;
        this.to = to;
    }
}

