package toolbox.common.workflow.core;

import toolbox.common.workflow.engine.ExecutionContext;

public interface TransitionCondition {
    
    String getExpression();
    
    <T> boolean evaluate(ExecutionContext<T> context);
}
