package com.zing.vchat.resources;


@Singleton
@Path("conversation")
public class Conversation {

    /**
     * 获取会话列表
     * @param request HTTP 请求
     * @param message 消息
     * @return 状态码
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getConversations(@Context HttpServletRequest request) {
       
    }


    /**
     * 新建会话
     * @param request HTTP 请求
     * @param message 消息
     * @return 状态码
     */
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response newConversation(@Context HttpServletRequest request, MessageJson message) {
       
    }

    /**
     * 删除会话
     * @param request HTTP 请求
     * @param message 消息
     * @return 状态码
     */
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteConversation(@Context HttpServletRequest request, MessageJson message) {
       
    }

    /**
     * 修改会话(退出、邀请、修改)
     * @param request HTTP 请求
     * @param message 消息
     * @return 状态码
     */
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response modifyConversation(@Context HttpServletRequest request, MessageJson message) {
       
    }
}
