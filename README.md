# LiteWorkflow
Lightweight event driven workflow execution engine.

## Core concepts  

**Workflow** static workflow definition   
**Phase** static workflow state representation  
**Transition** connecting from and to phases with transition condition. There are two types MANUAL, AUTO transitions.  
**Task** executable unit called by specific event handler at specific workflow lifycycle. Javascript based script  task is default supported. In javascript runtime environment **ActiveRecord** and **ObjectMirror** used to operate POJO object in JVM. **ActiveRecord** is used to operate relex Map\<String, Object> data container. **ObjectMirror** is used to operate strong type java object.  
**TaskExecutionLifecycle** static enum lifecycle point to define action execution time line such as **WorkflowStarting**, **PhaseEntering**, **PhaseLeft**  
**Execution** An instance of workflow running  
**ExecutionContext** Task execution context to relate data and state transfer between whole execution lifecycle.  
**Event** workflow execution event such as **WorkflowStartingEvent**, **PhaseEnteringEvent**, **PhaseLeftEvent**, **TransitionStartingEvent**  
**EventBus** event pub sub system to decouple workflow action execution process using Spring ApplicationEventPublisher   
**ExecutionService** is the driver to trigger event on execution and other tasks such as providing if concurrent execution strategy

## Usage
**Spring Data JPA** is required  
Just simply focus on **WorkflowManagementService** and **ExecutionService** for common usage  
**WorkflowManagementService** is used to manage static workflow definition. Classic methods are like below,    
createWorkflow, addPhaseToWorkflow, addTransitionToWorkflow, bindTaskToWorkflow  
**ExecutionService** is used to do operation over workflow execution such as startWorkflow, doTransition, forceToPhase  
