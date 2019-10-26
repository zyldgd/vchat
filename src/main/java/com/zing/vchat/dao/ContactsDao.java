package com.zing.vchat.dao;

import com.zing.vchat.JsonElement.ContactJson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ContactsDao {
    public static boolean createContactsTable(String userId) {
        DBApi dbApi = new DBApi(DBApi.MOYU_CONTACTS_DB);
        Connection connection = dbApi.getConnection();
        String sql = "CREATE TABLE IF NOT EXISTS `" + userId + "`(" +
                "  `contactId` INT(32) UNSIGNED NOT NULL PRIMARY KEY," +
                "  `type` VARCHAR(255) NOT NULL," +
                "  `remarkName` VARCHAR(255)" +
                ") ENGINE = InnoDB CHARACTER SET = utf8mb4";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean dropContactsTable(String userId) {
        DBApi dbApi = new DBApi(DBApi.MOYU_CONTACTS_DB);
        Connection connection = dbApi.getConnection();
        String sql = "DROP TABLE IF EXISTS `" + userId + "`";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static LinkedList<ContactJson> getContacts(String userId) {
        DBApi dbApi = new DBApi(DBApi.MOYU_CONTACTS_DB);
        Connection connection = dbApi.getConnection();
        String sql = "SELECT * FROM `" + userId + "`";
        LinkedList<ContactJson> ContactJsons = new LinkedList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ContactJsons.add(new ContactJson(resultSet.getString("contactId"),
                        resultSet.getString("type"),
                        resultSet.getString("remarkName")));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return ContactJsons;
        }
        return ContactJsons;
    }
    
    public static void main(String[] args){
        ContactsDao.getContacts("100000");
    }



}
