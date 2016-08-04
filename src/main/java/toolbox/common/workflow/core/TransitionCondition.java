package toolbox.common.workflow.core;

import com.hpe.sm.workflow.engine.ExecutionContext;

public interface TransitionCondition {
    
    String getName();
    
    String getDescription();
    
    <T> boolean evaluate(ExecutionContext<T> context);
}
