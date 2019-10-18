package com.zing.vchat.resources;

import com.zing.vchat.JsonElement.ResponseCodeJson;
import com.zing.vchat.JsonElement.TokenJson;
import com.zing.vchat.JsonElement.UserJson;
import com.zing.vchat.base.HttpHeaderKey;
import com.zing.vchat.base.ResponseCode;
import com.zing.vchat.base.Token;
import com.zing.vchat.cache.UsersCache;
import com.zing.vchat.util.AuthorizationUtils;

import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Singleton
@Path("login")
public class Login {

    @GET
    @Path("/test")
    @Produces({MediaType.APPLICATION_JSON})
    //@Consumes({MediaType.APPLICATION_JSON})
    public Response login(@Context HttpServletRequest request) {
        if (!AuthorizationUtils.isPass(request)){
            return Response.ok(new ResponseCodeJson(ResponseCode.FAIL)).build();
        }
        return Response.ok(new ResponseCodeJson(ResponseCode.SUCCEED)).build();
    }


    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response logout(@Context HttpServletRequest request) {
        return Response.ok(new ResponseCodeJson(ResponseCode.SUCCEED)).build();
    }

    @GET
    @Path("/token")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getToken(@Context HttpServletRequest request) {
        String userId = request.getHeader(HttpHeaderKey.USER_ID.toString());
        String password = request.getHeader(HttpHeaderKey.USER_PASSWORD.toString());

        //TODO 检查用户合法性，并返回 token
        if (userId.equals("admin") && password.equals("admin")){
            UsersCache.crateUserCacheInfo(userId);
            TokenJson tokenJson = new TokenJson(userId,UsersCache.setToken(userId));
            return Response.ok(tokenJson).build();
        }else{
            return Response.ok(new ResponseCodeJson(ResponseCode.FAIL)).build();
        }
    }
}




