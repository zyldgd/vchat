package com.zing.vchat.dao;

import com.zing.vchat.JsonElement.MessageJson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class membersDao {


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
}
