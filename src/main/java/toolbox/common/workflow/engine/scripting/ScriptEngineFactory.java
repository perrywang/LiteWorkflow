package toolbox.common.workflow.engine.scripting;

import javax.annotation.PostConstruct;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ScriptEngineFactory {
    
    private static ScriptEngineFactory self;
    
    private ThreadLocal<ScriptEngine> scriptEngine = new ThreadLocal<ScriptEngine>(){
        @Override
        protected ScriptEngine initialValue() {
          return new ScriptEngineManager().getEngineByName("nashorn");
        } 
    };
    
    private ThreadLocal<Boolean> initialized = new ThreadLocal<Boolean>(){
        @Override
        protected Boolean initialValue() {
          return false;
        } 
    };
    
    @PostConstruct
    public void initialized() {
        ScriptEngineFactory.self = this;
    }
      
    private ScriptEngine createEngineInternal() {
        ScriptEngine engine = scriptEngine.get();
        if(!initialized.get()){
            initialize(engine);
            initialized.set(true);
        }
        return engine;
    }
    
    public static ScriptEngine createEngine() {
        return self.createEngineInternal();
    }
    
    private void initialize(ScriptEngine engine) {
        log.info("initialing javascript execution engine");
        loadPreloadJavaObject(engine);
        //TODO inject other global java object such as logger, javascript code. business logic will bind local file variables in workflow service
    }
    
    private void loadPreloadJavaObject(ScriptEngine engine) {
        engine.put("logger", log);
    }
}
