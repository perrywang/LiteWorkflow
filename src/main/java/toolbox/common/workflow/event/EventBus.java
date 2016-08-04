package toolbox.common.workflow.event;

public interface EventBus {
    
    <T> void register(EventSubscriber<T> subscriber);
    
    void publish(Event event);
    
}
