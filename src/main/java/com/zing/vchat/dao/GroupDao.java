package com.zing.vchat.dao;

import com.zing.vchat.JsonElement.GroupJson;
import com.zing.vchat.JsonElement.MemberJson;
import com.zing.vchat.JsonElement.MessageJson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class GroupDao {

    public static boolean createMembersTable(String groupId) {
        DBApi dbApi = new DBApi(DBApi.MOYU_MEMBERS_DB);
        Connection connection = dbApi.getConnection();
        String sql = "CREATE TABLE IF NOT EXISTS `" + groupId + "`(" +
                "  `memberId` INTEGER(32) UNSIGNED NOT NULL PRIMARY KEY," +
                "  `role` VARCHAR(255) NOT NULL," +
                "  `nickname` VARCHAR(255)" +
                ") ENGINE = InnoDB, CHARACTER SET = utf8mb4";
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

    public static boolean dropMembersTable(String groupId) {
        DBApi dbApi = new DBApi(DBApi.MOYU_MEMBERS_DB);
        Connection connection = dbApi.getConnection();
        String sql = "DROP TABLE IF EXISTS `" + groupId + "`";

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

    public static boolean insertGroup(GroupJson groupJson) {
        DBApi dbApi = new DBApi(DBApi.MOYU_MEMBERS_DB);
        Connection connection = dbApi.getConnection();
        String sql = "DROP TABLE IF EXISTS `" + groupJson.getGroupId() + "`";

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

    public static boolean updateGroup(GroupJson groupJson){
        // TODO 更新信息
        return true;
    }

    public static GroupJson queryGroupById(String groupId){
        // TODO 查询组信息
        return null;
    }

    public static List<GroupJson> queryGroupByNickname(String nickname){
        // TODO 查询组s信息
        return null;
    }

    public static boolean deleteGroup(String groupId) {
        // TODO 删除组，并删除相应的成员表
        return true;
    }

    public static boolean insertMembers(String groupId, List<String> memberId) {
        // TODO 添加成员s
        return true;
    }

    public static void main(String[] args){
        GroupDao.createMembersTable("111");
    }
}
