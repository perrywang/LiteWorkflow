package toolbox.common.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import toolbox.common.workflow.entity.Execution;

public interface ExecutionRepository extends JpaRepository<Execution, Long>{

}
