package com.zing.vchat.resources;

import com.zing.vchat.JsonElement.UserJson;
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
    @Path("/token")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getToken(UserJson user) {
        System.out.println(user);
        return Response.ok(String.format("{\"token\":%s}", 5)).build();
    }


    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response login(@Context HttpServletRequest request) {


        return Response.ok("123").build();
    }

}




