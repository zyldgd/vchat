package com.zing.vchat.resources;

import com.zing.vchat.JsonElement.ResponseCodeJson;
import com.zing.vchat.JsonElement.TokenJson;
import com.zing.vchat.base.HttpHeaderKey;
import com.zing.vchat.base.ResponseCode;
import com.zing.vchat.base.Token;
import com.zing.vchat.cache.UsersCache;
import com.zing.vchat.dao.UsersDao;
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
    public Response login(@Context HttpServletRequest request) {
        if (!AuthorizationUtils.isPass(request)) {
            return Response.ok(new ResponseCodeJson(ResponseCode.FAIL)).build();
        }
        return Response.ok(new ResponseCodeJson(ResponseCode.SUCCEED)).build();
    }


    @DELETE
    @Path("/token")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteToken(@Context HttpServletRequest request) {
        if (!AuthorizationUtils.isPass(request)) {
            return Response.ok(new ResponseCodeJson(ResponseCode.FAIL)).build();
        }
        String userId = request.getHeader(HttpHeaderKey.USER_ID.toString());
        UsersCache.deleteToken(userId);
        return Response.ok(new ResponseCodeJson(ResponseCode.SUCCEED)).build();
    }


    @GET
    @Path("/token")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getToken(@Context HttpServletRequest request) {
        String username = request.getHeader(HttpHeaderKey.USER_NAME.toString());
        if (AuthorizationUtils.verify(request)) {
            String userId = UsersDao.queryByName(username).getUserId();
            Token token = UsersCache.setToken(userId);
            TokenJson tokenJson = new TokenJson(userId, token);
            return Response.ok(tokenJson).build();
        } else {
            return Response.ok(new ResponseCodeJson(ResponseCode.FAIL)).build();
        }
    }
}




