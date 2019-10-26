package com.zing.vchat.resources;

import com.zing.vchat.JsonElement.ContactJson;
import com.zing.vchat.base.StatusCode;
import com.zing.vchat.dao.ContactsDao;
import com.zing.vchat.util.AuthorizationUtils;

import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;

@Singleton
@Path("contacts")
public class Contacts {

    /**
     * 获取通讯录
     *
     * @param request HTTP 请求
     * @return EventOutput
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getContacts(@Context HttpServletRequest request) {
        if (!AuthorizationUtils.isPass(request)) {
            return Response.status(StatusCode.Forbidden.getCode()).build();
        }
        String userId = AuthorizationUtils.getUserId(request);
        LinkedList<ContactJson> contactJsons = ContactsDao.getContacts(userId);
        return Response.ok(contactJsons).build();
    }


    /**
     * 添加通信录信息
     *
     * @param request HTTP 请求
     * @return EventOutput
     */
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response postContact(@Context HttpServletRequest request, @QueryParam("ContactId") String ContactId, @QueryParam("ContactType") String ContactType) {
        if (!AuthorizationUtils.isPass(request)) {
            return Response.status(StatusCode.Forbidden.getCode()).build();
        }
        // TODO  添加通信录信息
        return Response.ok().build();
    }


    /**
     * 删除通信录信息
     *
     * @param request HTTP 请求
     * @return EventOutput
     */
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteContact(@Context HttpServletRequest request, @QueryParam("ContactId") String ContactId, @QueryParam("ContactType") String ContactType) {
        if (!AuthorizationUtils.isPass(request)) {
            return Response.status(StatusCode.Forbidden.getCode()).build();
        }
        // TODO  删除通信录信息
        return Response.ok().build();
    }

    /**
     * 修改通信录信息
     *
     * @param request HTTP 请求
     * @return EventOutput
     */
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response putContact(@Context HttpServletRequest request, ContactJson contactJson) {
        if (!AuthorizationUtils.isPass(request)) {
            return Response.status(StatusCode.Forbidden.getCode()).build();
        }
        // TODO  删除通信录信息
        return Response.ok().build();
    }
}
