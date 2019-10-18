package com.zing.vchat.resources;


import com.zing.vchat.JsonElement.ResponseCode;
import com.zing.vchat.cache.EventSourceCache;
import com.zing.vchat.cache.UserCache;
import com.zing.vchat.util.RequestUtils;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.UUID;

@Singleton
@Path("eventSource")
public class EventSource {
    /**
     * //@param request HTTP 请求
     * @return EventOutput
     * @description 提供 SSE 事件输出通道的资源方法
     */
    @GET
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput getEventSource( @QueryParam("token") String token) throws IOException {
        String userId = UserCache.getInstance().getUserId(token);
        EventOutput eventOutput;
        OutboundEvent outboundEvent;
        if (userId != null){
            if (UserCache.getInstance().getToken(userId).isValid()){
                eventOutput = EventSourceCache.getInstance().setEventOutput(userId);
                outboundEvent = new OutboundEvent.Builder().name("getEventSource").data("yes").build();
            }else{
                eventOutput = new EventOutput();
                outboundEvent = new OutboundEvent.Builder().name("getEventSource").data("token_invalid").build();
            }
        }else{
            eventOutput = new EventOutput();
            outboundEvent = new OutboundEvent.Builder().name("getEventSource").data("no_login").build();
        }
        eventOutput.write(outboundEvent);
        return eventOutput;
    }


    /**
     * @param request HTTP 请求
     * @description 提供 删除 SSE 事件通道的资源方法
     */
    @DELETE
//    @Produces(SseFeature.SERVER_SENT_EVENTS)
    @Consumes({MediaType.APPLICATION_JSON})
    public Response disconnectOnBroadcast(@Context HttpServletRequest request) {
        UUID token_uuid = RequestUtils.getTokenUUID(request);
        String userId = UserCache.getInstance().getUserId(token_uuid);
        EventSourceCache.getInstance().deleteEventOutput(userId);
        return Response.ok(ResponseCode.INEXISTENCE).build();
    }

}
