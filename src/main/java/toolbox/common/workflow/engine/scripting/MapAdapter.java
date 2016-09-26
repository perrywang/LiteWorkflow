package toolbox.common.workflow.engine.scripting;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class MapAdapter implements Map<String, Object>{
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(String key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Object> m) {
        
    }

    @Override
    public void clear() {
        
    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<Object> values() {
        return null;
    }

    @Override
    public Set<java.util.Map.Entry<String, Object>> entrySet() {
        return null;
    }
}
