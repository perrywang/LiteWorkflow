package toolbox.common.workflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import toolbox.common.workflow.core.ActionLifecycle;
import toolbox.common.workflow.core.WorkflowAction;
import toolbox.common.workflow.entity.ActionEntity;
import toolbox.common.workflow.entity.PhaseEntity;
import toolbox.common.workflow.entity.WorkflowEntity;

public interface ActionRepository extends JpaRepository<ActionEntity, Long> {
    
    List<WorkflowAction> findByWorkflowAndLifecycle(WorkflowEntity workflow, ActionLifecycle lifecycle);
    
    List<WorkflowAction> findByPhaseAndLifecycle(PhaseEntity workflow, ActionLifecycle lifecycle);
    
}
