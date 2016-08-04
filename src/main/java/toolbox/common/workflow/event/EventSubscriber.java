package toolbox.common.workflow.event;

public interface EventSubscriber<T> {
    
    void handleEvent(T event);
    
    Class<T> supportedEvent();

}
