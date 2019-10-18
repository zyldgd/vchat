package com.zing.ichat.resources;

import com.zing.ichat.Authorization;
import com.zing.ichat.User;
import com.zing.ichat.util.AuthorizationUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("login")
public class Login {

    @GET
    @Path("/token")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getToken(User user) {
        System.out.println(user);
        String token = AuthorizationUtils.makeToken(user.getUsername());
        return Response.ok(String.format("{\"token\":%s}", token)).build();
    }


    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response login(@Context HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        System.out.println(authorizationHeader);
        return Response.ok("123").build();
    }

}




