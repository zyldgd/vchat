package com.zing.vchat.dao;

import com.zing.vchat.JsonElement.UserJson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;



public class UsersDao {

    public static UserJson queryById(String userId) {
        DBApi dbApi = new DBApi(DBApi.MOYU_DB);
        Connection connection = dbApi.getConnection();
        String sql = "SELECT * FROM users WHERE userId = ?";
        UserJson userJson = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                userJson = getUserJson(resultSet);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userJson;
    }

    public static UserJson queryByName(String username) {
        DBApi dbApi = new DBApi(DBApi.MOYU_DB);
        Connection connection = dbApi.getConnection();
        String sql = "SELECT * FROM users WHERE username = ?";
        UserJson userJson = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                userJson = getUserJson(resultSet);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userJson;
    }

    public static List<UserJson> getAll() {
        DBApi dbApi = new DBApi(DBApi.MOYU_DB);
        Connection connection = dbApi.getConnection();
        String sql = "SELECT * FROM users";

        List<UserJson> list = new LinkedList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                list.add(getUserJson(resultSet));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean exist(String username) {
        DBApi dbApi = new DBApi(DBApi.MOYU_DB);
        Connection connection = dbApi.getConnection();
        String sql = "SELECT EXISTS(SELECT * FROM users WHERE username = ?)";
        boolean isExist = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                isExist = resultSet.getBoolean(1);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isExist;
    }

    public static boolean verify(String userId, String password) {
        DBApi dbApi = new DBApi(DBApi.MOYU_DB);
        Connection connection = dbApi.getConnection();
        String sql = "SELECT EXISTS(SELECT * FROM users WHERE userId = ? AND password = SHA(?))";
        boolean re = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                re = resultSet.getBoolean(1);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return re;
    }

    public static boolean verifyBuName(String username, String password) {
        DBApi dbApi = new DBApi(DBApi.MOYU_DB);
        Connection connection = dbApi.getConnection();
        String sql = "SELECT EXISTS(SELECT * FROM users WHERE username = ? AND password = SHA(?))";
        boolean re = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                re = resultSet.getBoolean(1);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return re;
    }

    public static boolean insert(UserJson userJson) {
        DBApi dbApi = new DBApi(DBApi.MOYU_DB);
        Connection connection = dbApi.getConnection();
        String sql = "INSERT INTO users(username, password, nickname, email, avatarPath, remark, grade) VALUES(?,SHA(?),?,?,?,?,?)";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userJson.getUsername());
            preparedStatement.setString(2, userJson.getPassword());
            preparedStatement.setString(3, userJson.getNickname());
            preparedStatement.setString(4, userJson.getEmail());
            preparedStatement.setString(5, null);
            preparedStatement.setString(6, userJson.getRemark());
            preparedStatement.setInt(7, 1);
            preparedStatement.execute();
            connection.commit();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean update(UserJson userJson) {
        DBApi dbApi = new DBApi(DBApi.MOYU_DB);
        Connection connection = dbApi.getConnection();
        //TODO 更新用户信息
        return false;
    }

    public static boolean delete(String userId) {
        DBApi dbApi = new DBApi(DBApi.MOYU_DB);
        Connection connection = dbApi.getConnection();
        //TODO 注销用户
        return false;
    }

    private static UserJson getUserJson(ResultSet resultSet) throws SQLException {
        UserJson userJson = new UserJson();
        userJson.setUserId(resultSet.getString("userId"));
        userJson.setUsername(resultSet.getString("username"));
        userJson.setPassword(resultSet.getString("password"));
        userJson.setNickname(resultSet.getString("nickname"));
        userJson.setEmail(resultSet.getString("email"));
        userJson.setAvatarPath(resultSet.getString("avatarPath"));
        userJson.setRemark(resultSet.getString("remark"));
        userJson.setGrade(resultSet.getInt("grade"));
        return userJson;
    }

    public static void main(String[] args) {

    }
}
