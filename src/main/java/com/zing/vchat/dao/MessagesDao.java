package com.zing.vchat.dao;

import com.zing.vchat.JsonElement.MessageJson;
import com.zing.vchat.JsonElement.UserJson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessagesDao {

    public static void insert(MessageJson messageJson) {
        String messageType = messageJson.getMessageType();

        if (messageType.equals("private")) {
            DBApi dbApi = new DBApi(DBApi.MOYU_MESSAGES_DB);
            Connection connection = dbApi.getConnection();
            String sql = "INSERT INTO `" + messageJson.getReceiverId() + "`(messageHash, content, senderId, messageType, receiverId, date, time) VALUES(?,?,?,?,?,?,?)";
            try {
                connection.setAutoCommit(false);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, messageJson.getMessageHash());
                preparedStatement.setString(2, messageJson.getContent());
                preparedStatement.setString(3, messageJson.getSenderId());
                preparedStatement.setString(4, messageJson.getMessageType());
                preparedStatement.setString(5, messageJson.getReceiverId());
                preparedStatement.setString(6, messageJson.getDate());
                preparedStatement.setString(7, messageJson.getTime());
                preparedStatement.execute();
                connection.commit();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (messageType.equals("public")) {
            // TODO 首先得到群聊的成员，然后一个个存入消息
        }
    }




    public static void main(String[] args){
        MessageJson messageJson = new MessageJson();

        messageJson.setContent("love u");
        messageJson.setMessageHash("c4662daf16d885313246d60fd5ace965");
        messageJson.setDate("2019-10-24");
        messageJson.setTime("01:10:55");
        messageJson.setSenderId("100000");
        messageJson.setReceiverId("100001");
        messageJson.setMessageType("private");

        MessagesDao.insert(messageJson);
    }
}