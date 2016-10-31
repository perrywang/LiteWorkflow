package toolbox.common.workflow.engine.scripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScriptEngineFactory {
    
    private static ThreadLocal<ScriptEngine> scriptEngine = new ThreadLocal<ScriptEngine>(){
        @Override
        protected ScriptEngine initialValue() {
          return new ScriptEngineManager().getEngineByName("nashorn");
        } 
    };
    
    private static ThreadLocal<Boolean> initialized = new ThreadLocal<Boolean>(){
        @Override
        protected Boolean initialValue() {
          return false;
        } 
    };
    
    public static ScriptEngine createEngine() {
        ScriptEngine engine = scriptEngine.get();
        if(!initialized.get()){
            initialize(engine);
            initialized.set(true);
        }
        return engine;
    }
    
    private static void initialize(ScriptEngine engine) {
        log.info("initialing javascript execution engine");
        loadPreloadJavaObject(engine);
    }
    
    private static void loadPreloadJavaObject(ScriptEngine engine) {
        engine.put("logger", log);
    }
    
}
