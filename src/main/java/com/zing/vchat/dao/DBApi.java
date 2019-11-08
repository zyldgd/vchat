package com.zing.vchat.dao;

import javax.ws.rs.PUT;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBApi {
    private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    public static final String MOYU_DB = "jdbc:mariadb://172.20.71.3:3306/moyuDB";
    public static final String MOYU_MESSAGES_DB = "jdbc:mariadb://172.20.71.3:3306/moyu_messagesDB";
    public static final String MOYU_CONTACTS_DB = "jdbc:mariadb://172.20.71.3:3306/moyu_contactsDB";
    public static final String MOYU_MEMBERS_DB = "jdbc:mariadb://172.20.71.3:3306/moyu_membersDB";

    private static String DB_URL;
    private static final String USER = "root";
    private static final String PASS = "root";

    private Connection connection = null;

    public DBApi(String dbName){
        this.DB_URL = dbName;
        this.connect();
    }

    private boolean connect(){
        System.out.println("[INFO] 连接数据库...");
        try {
            Class.forName(JDBC_DRIVER); // 注册 JDBC 驱动
            connection = DriverManager.getConnection(DB_URL, USER, PASS);// 打开链接
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Connection getConnection(){
        return connection;
    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement getPreparedStatement(String sql){
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
