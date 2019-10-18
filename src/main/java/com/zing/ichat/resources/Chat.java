package com.zing.ichat.resources;

import com.zing.ichat.Message;
import com.zing.ichat.MessageType;
import com.zing.ichat.util.BroadcastUtils;
import com.zing.ichat.util.RequestUtils;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseBroadcaster;
import org.glassfish.jersey.media.sse.SseFeature;

import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.*;


@Singleton
@Path("chat")
public class Chat {

    static String token = "token—test";
    /**
     * //@param request HTTP 请求
     * @return EventOutput
     * @description 提供 SSE 事件输出通道的资源方法
     */
    @GET
    @Path("/broadcast")
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput listenToBroadcast(@QueryParam("token") String token) {
        return BroadcastUtils.addEventOutput(token);
        //return BroadcastUtils.addEventOutput(RequestUtils.getToken(request));
    }

    /**
     * @param request HTTP 请求
     * @param message 接受消息
     * @description 提供 写入 SSE 事件通道的资源方法
     */
    @POST
    @Path("/broadcast")
    @Produces(MediaType.APPLICATION_JSON)
    public void broadcastMessage(@Context HttpServletRequest request, Message message) {
        System.out.println(message);
        BroadcastUtils.broadcast(MediaType.APPLICATION_JSON_TYPE, message);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Message get() {
        Message message = new Message();
        message.setContent("123");
        message.setDate("12345");
        message.setDestination("1");
        message.setSource("3");
        message.setTime("3");
        message.setMessageType(MessageType.BROADCAST);
        return message;
    }


}
