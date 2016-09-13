package toolbox.common.workflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import toolbox.common.workflow.core.WorkflowPhase;
import toolbox.common.workflow.entity.PhaseEntity;
import toolbox.common.workflow.entity.WorkflowEntity;

public interface PhaseRepository extends JpaRepository<PhaseEntity, Long>{
    List<WorkflowPhase> findByWorkflow(WorkflowEntity workflow);
}
