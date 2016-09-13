package toolbox.common.workflow.entity;

import javax.persistence.Embeddable;

import lombok.Data;
import toolbox.common.workflow.core.TransitionCondition;
import toolbox.common.workflow.engine.ExecutionContext;

@Embeddable
@Data
public class TransitionConditionVO implements TransitionCondition {
    
    private String expression;
    
    public TransitionConditionVO(String expression) {
        this.expression = expression;
    }

    @Override
    public <T> boolean evaluate(ExecutionContext<T> context) {
        // TODO Auto-generated method stub
        return false;
    }

}
