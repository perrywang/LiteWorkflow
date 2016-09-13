package toolbox.common.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import toolbox.common.workflow.entity.WorkflowEntity;

public interface WorkflowRepository extends JpaRepository<WorkflowEntity, Long> {
}
