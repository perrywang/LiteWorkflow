package toolbox.common.workflow.core;

import java.util.Set;

public interface Context {
    
    Object getProperty(String name);
    
    void setProperty(String name, Object value);
    
    Set<String> getPropertyNames();
}
