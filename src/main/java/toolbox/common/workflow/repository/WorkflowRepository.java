package toolbox.common.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import toolbox.common.workflow.entity.Workflow;

public interface WorkflowRepository extends JpaRepository<Workflow, Long> {
}
