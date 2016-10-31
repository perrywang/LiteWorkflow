# LiteWorkflow
Lightweight event driven workflow execution engine.

## Core concepts  

**Workflow** static workflow definition   
**Phase** static workflow state representation  
**Transition** connecting from and to WorkflowPhase with TransitionCondition  
**Task** executable unit called by specific event handler at specific workflow lifycycle.  
**TaskExecutionLifecycle** static enum lifecycle point to define action execution time line such as **WorkflowStarting**, **PhaseEntering**, **PhaseLeft**  
**Execution** An instance for workflow running  
**ExecutionContext** running context to relate data and state transfer between whole execution lifecycle.  
**Event** workflow execution event such as **WorkflowStartingEvent**, **PhaseEnteringEvent**, **PhaseLeftEvent**, **TransitionStartingEvent**  
**EventBus** event pub sub system to decouple workflow action execution process using Spring ApplicationEventPublisher   
**ExecutionService** is the driver to trigger event on execution and other tasks such as providing if concurrent execution strategy

## Usage
**Spring Data JPA** is required  
Just simply focus on **WorkflowManagementService** and **ExecutionService** for common usage  
**WorkflowManagementService** is used to manage static workflow definition. Classic methods are like below,    
createWorkflow, addPhaseToWorkflow, addTransitionToWorkflow, bindTaskToWorkflow  
**ExecutionService** is used to do operation over workflow such as startWorkflow, doTransition, forceToPhase  
