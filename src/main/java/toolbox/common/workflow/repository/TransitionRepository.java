package toolbox.common.workflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import toolbox.common.workflow.entity.Phase;
import toolbox.common.workflow.entity.Transition;
import toolbox.common.workflow.entity.Workflow;

public interface TransitionRepository extends JpaRepository<Transition, Long> {
    
    List<Transition> findByWorkflow(Workflow workflow);
    
    List<Transition> findByFrom(Phase from);
}
