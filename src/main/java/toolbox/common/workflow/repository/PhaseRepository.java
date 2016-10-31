package toolbox.common.workflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import toolbox.common.workflow.entity.Phase;
import toolbox.common.workflow.entity.Workflow;

public interface PhaseRepository extends JpaRepository<Phase, Long>{
    
    List<Phase> findByWorkflow(Workflow workflow);
    
    Phase findByWorkflowAndIsStart(Workflow workflow, boolean isStart);
    
}
