package com.zing.vchat.cache;

import org.glassfish.jersey.media.sse.EventOutput;

import javax.inject.Singleton;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class EventSourceCache {
    private static EventSourceCache eventSourceCache = new EventSourceCache();

    private Map<String, EventOutput> eventOutputs;

    public static EventSourceCache getInstance(){
        return EventSourceCache.eventSourceCache;
    }

    private  EventSourceCache(){
        this.eventOutputs = new ConcurrentHashMap<>();
    }

    public EventOutput getEventOutput(String userId){
        return this.eventOutputs.get(userId);
    }

    public void deleteEventOutput(String userId){
        this.eventOutputs.remove(userId);
    }

    public void clearAllEventOutputs(){
        this.eventOutputs.clear();
    }

    public void setEventOutput(String userId, EventOutput eventOutput){
        this.eventOutputs.put(userId, eventOutput);
    }

    public EventOutput setEventOutput(String userId){
        EventOutput eventOutput = new EventOutput();
        this.eventOutputs.put(userId, eventOutput);
        return eventOutput;
    }
}
