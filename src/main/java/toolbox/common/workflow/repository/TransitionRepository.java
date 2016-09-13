package toolbox.common.workflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import toolbox.common.workflow.core.WorkflowTransition;
import toolbox.common.workflow.entity.PhaseEntity;
import toolbox.common.workflow.entity.TransitionEntity;

public interface TransitionRepository extends JpaRepository<TransitionEntity, Long> {
    List<WorkflowTransition> findByFrom(PhaseEntity from);
}
