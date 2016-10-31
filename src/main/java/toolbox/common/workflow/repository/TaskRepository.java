package toolbox.common.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import toolbox.common.workflow.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> { 
}
