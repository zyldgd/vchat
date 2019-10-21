package com.zing.vchat.resources;

import com.zing.vchat.JsonElement.MessageJson;
import com.zing.vchat.JsonElement.ResponseCodeJson;
import com.zing.vchat.base.ResponseCode;
import com.zing.vchat.cache.UsersCache;
import com.zing.vchat.message.MessageCollector;
import com.zing.vchat.util.AuthorizationUtils;

import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Singleton
@Path("messages")
public class Messages {


    /**
     * 获取消息
     * @param request HTTP 请求
     * @return EventOutput
     */
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getMessages(@Context HttpServletRequest request) {
        if(!AuthorizationUtils.isPass(request)){
            return Response.ok(new ResponseCodeJson(ResponseCode.FAIL)).build();
        }
        return Response.ok(UsersCache.getMessageBox(AuthorizationUtils.getUserId(request)).getMessagesCache()).build();
    }


    /**
     * 上传消息
     * @param request HTTP 请求
     * @param message 消息
     * @return 状态码
     */
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response postMessages(@Context HttpServletRequest request, MessageJson message) {
        if(!AuthorizationUtils.isPass(request)){
            return Response.ok(new ResponseCodeJson(ResponseCode.FAIL)).build();
        }
        MessageCollector.getInstance().putToMessageQueue(message);
        return Response.ok(new ResponseCodeJson(ResponseCode.SUCCEED)).build();
    }

    /**
     * 删除消息
     * @param request HTTP 请求
     * @param message 消息
     * @return 状态码
     */
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response deleteMessages(@Context HttpServletRequest request, Object message) {
        //TODO 删除消息
        return null;
    }

    /**
     * 撤回消息
     * @param request HTTP 请求
     * @param message 撤回消息的ID, 和消息所在会话的ID
     * @return 状态码
     */
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response WithdrawMessages(@Context HttpServletRequest request, Object message) {
        //TODO 撤回消息，并删除消息
        return null;
    }

}
