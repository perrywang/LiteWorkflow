package toolbox.common.workflow.repository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class RepositoryRegistry {
    
    private static RepositoryRegistry self;
    
    @Autowired
    private WorkflowRepository workflowRepo;
    
    @Autowired
    private PhaseRepository phaseRepo;
    
    @Autowired
    private TransitionRepository transitionRepository;
    
    @Autowired
    private ActionRepository actionRepository;
    
    @PostConstruct
    public void initialized() {
        RepositoryRegistry.self = this;
    }
    
    public static RepositoryRegistry instance() {
        return self;
    }
}
