package toolbox.common.workflow.service;

import toolbox.common.workflow.core.ExecutionContext;
import toolbox.common.workflow.entity.Execution;
import toolbox.common.workflow.entity.Phase;
import toolbox.common.workflow.entity.Transition;
import toolbox.common.workflow.entity.Workflow;

public interface ExecutionService {
    
    Execution startWorkflow(Workflow workflow, ExecutionContext context);
    
    void doTransition(Execution execution, Transition transition, ExecutionContext context);
    
    void forceToPhase(Execution execution,Phase phase);
}
