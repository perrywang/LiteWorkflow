package toolbox.common.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import toolbox.common.workflow.entity.TransitionHistory;

public interface TransitionHistoryRepository extends JpaRepository<TransitionHistory, Long>{

}
