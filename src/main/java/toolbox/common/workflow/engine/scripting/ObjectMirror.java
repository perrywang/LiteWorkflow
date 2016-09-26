package toolbox.common.workflow.engine.scripting;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class ObjectMirror extends MapAdapter{
    
    private BeanWrapper wrapper;
    
    public ObjectMirror(Object object) {
        this.wrapper = new BeanWrapperImpl(object);
    }
    
    @Override
    public Object get(Object propertyName) {
        return wrapper.getPropertyValue((String)propertyName);
    }
    
    @Override
    public Object put(String propertyName, Object value) {
        Object old = get(propertyName);
        wrapper.setPropertyValue(propertyName, value);
        return old;
    }
}

