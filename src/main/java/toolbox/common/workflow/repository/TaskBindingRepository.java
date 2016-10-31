package toolbox.common.workflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import toolbox.common.workflow.core.TaskExecutionLifecycle;
import toolbox.common.workflow.entity.Phase;
import toolbox.common.workflow.entity.TaskBinding;
import toolbox.common.workflow.entity.Workflow;

public interface TaskBindingRepository extends JpaRepository<TaskBinding, Long>{
    
    List<TaskBinding> findByWorkflowAndLifecycle(Workflow workflow, TaskExecutionLifecycle lifecycle);
    
    List<TaskBinding> findByPhaseAndLifecycle(Phase phase, TaskExecutionLifecycle lifecycle);
}
