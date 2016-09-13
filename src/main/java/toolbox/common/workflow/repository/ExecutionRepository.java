package toolbox.common.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import toolbox.common.workflow.entity.ExecutionEntity;

public interface ExecutionRepository extends JpaRepository<ExecutionEntity, Long>{

}
