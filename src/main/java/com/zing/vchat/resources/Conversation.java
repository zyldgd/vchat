package com.zing.vchat.resources;

import com.zing.vchat.JsonElement.Message;
import com.zing.vchat.JsonElement.ResponseCode;
import com.zing.vchat.cache.UserCache;
import com.zing.vchat.util.RequestUtils;

import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Singleton
@Path("conversation")
public class Conversation {


    /**
     * //@param request HTTP 请求
     * @return EventOutput
     * @description 提供 SSE 事件输出通道的资源方法
     */
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getConversation(@Context HttpServletRequest request) {
        UUID token_uuid = RequestUtils.getTokenUUID(request);
        String userId = UserCache.getInstance().getUserId(token_uuid);
        if (null != userId){
            return Response.ok(UserCache.getInstance().getMessageBox(userId).getMessages()).build();
        }else {
            return Response.ok(ResponseCode.FAILED).build();
        }
    }


    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response postConversation(@Context HttpServletRequest request, Message message) {
        UUID token_uuid = RequestUtils.getTokenUUID(request);

        return null;

    }





}
