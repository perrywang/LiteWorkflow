# LiteWorkflow
Lightweight event driven workflow execution engine.

## Core concepts  

**Workflow** static workflow definition   
**WorkflowPhase** workflow state representation   
**WorkflowAction** an executable code called by event handler at specific lifycycle
**WorkflowTransition** extends from WorkflowAction  
**WorkflowExecution** An instance for workflow running  
**ExecutionContext** running context to relate data and transfer between the execution lifecycle  
**Event** workflow execution lifecycle event such as **WorkflowStartingEvent**, **WorkflowStartedEvent**, **WorkflowPhaseEnteringEvent**, **WorkflowPhaseEnteredEvent**  
**EventBus** event pub sub system to decouple workflow action handler.
