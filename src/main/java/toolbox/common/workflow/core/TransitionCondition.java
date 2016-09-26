package toolbox.common.workflow.core;

import toolbox.common.workflow.engine.ExecutionContext;

public interface TransitionCondition {
    
    String getExpression();
    
    boolean evaluate(ExecutionContext context);
}
