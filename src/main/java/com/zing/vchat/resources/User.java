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
@Path("user")
public class User {
    
    /**
     * 获取/查询用户信息
     * @param request HTTP 请求
     * @return 状态码
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUser(@Context HttpServletRequest request) {
        
    }


    /**
     * 注册新用户
     * @param request HTTP 请求
     * @param message 消息
     * @return 状态码
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response newUser(@Context HttpServletRequest request, UserJson userJson) {
        // TODO 首先确认是新用户
        // TODO 写入数据库
        UserCache.crateUserCacheInfo(userJson);
        return Response.ok(new ResponseCodeJson(ResponseCode.SUCCEED)).build();
    }


    /**
     * 修改用户信息
     * @param request HTTP 请求
     * @return 状态码
     */
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response modifyUser(@Context HttpServletRequest request, MessageJson message) {
       
    }


    /**
     * 注销用户
     * @param request HTTP 请求
     * @return 状态码
     */
    @DELETE
    public Response deleteUser(@Context HttpServletRequest request, MessageJson message) {
       
    }

    /*************************************************************/




}
