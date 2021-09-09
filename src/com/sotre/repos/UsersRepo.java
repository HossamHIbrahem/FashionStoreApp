package com.sotre.repos;

import com.sotre.entities.Product_Country;
import com.sotre.entities.Users;
import com.store.managers.DBManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepo {

    public void insert(Users users) {
        PreparedStatement stmt = null;
        Connection conn = null;

        try {
            // JDBC
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("INSERT INTO users (`USR_ID`, `USR_FULL_NAME`, `EMAIL`, `USR_NAME`, `USR_PASSWORD`) VALUES (?, ?, ?, ?, ?)");

            stmt.setInt(1, users.getUserId());
            stmt.setString(2, users.getUserFullName());
            stmt.setString(3, users.getUserEmail());
            stmt.setString(4, users.getUserName());
            stmt.setInt(5, users.getUserPassword());

            int rec = stmt.executeUpdate();
            System.out.println(rec);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closePreparedStatement(stmt);
            DBManager.closeConnection(conn);

        }

    }

    public Users getUsersId(int userId) {
        Users users = null;

        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;

        try {

            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("SELECT `USR_ID`, `USR_FULL_NAME`, `EMAIL`, `USR_NAME`, `USR_PASSWORD` FROM users Where USR_ID = ?");
            stmt.setInt(1, userId);

            rs = stmt.executeQuery();

            if (rs.next()) {
                users = new Users();
                users.setUserId(rs.getInt("USR_ID"));
                users.setUserFullName(rs.getString("USR_FULL_NAME"));
                users.setUserEmail(rs.getString("EMAIL"));
                users.setUserName(rs.getString("USR_NAME"));
                users.setUserPassword(rs.getInt("USR_PASSWORD"));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeResultSet(rs);
            DBManager.closePreparedStatement(stmt);
            DBManager.closeConnection(conn);

            return users;
        }

    }

    public void delete(int userId) {
        PreparedStatement stmt = null;
        Connection conn = null;

        try {
            // JDBC
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("DELETE FROM users Where USR_ID = ? ");

            stmt.setInt(1, userId);

            int rec = stmt.executeUpdate();
            System.out.println(rec);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closePreparedStatement(stmt);
            DBManager.closeConnection(conn);

        }

    }

    public void update(Users users) {

        PreparedStatement stmt = null;
        Connection conn = null;

        try {
            // JDBC
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("UPDATE users SET USR_FULL_NAME = ? , EMAIL = ? , USR_NAME = ? WHERE USR_ID = ?");

            stmt.setString(1, users.getUserFullName());
            stmt.setString(2, users.getUserEmail());
            stmt.setString(3, users.getUserName());
            stmt.setInt(4, users.getUserId());

            int rec = stmt.executeUpdate();
            System.out.println(rec);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closePreparedStatement(stmt);
            DBManager.closeConnection(conn);

        }

    }

    public List<Users> getAllUsers() {

        List<Users> list = new ArrayList<Users>();

        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            // JDBC
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("SELECT `USR_ID`, `USR_FULL_NAME`, `EMAIL`, `USR_NAME`, `USR_PASSWORD` FROM users ");
            ResultSet rs = stmt.executeQuery();

            while (rs.next() == true) {

                System.out.println("User ID : " + rs.getInt("USR_ID") + " User Full Name : " + rs.getString("USR_FULL_NAME") + " User Email : " + rs.getString("EMAIL") + " User Name : " + rs.getString("USR_NAME") + " User Password : " + rs.getInt("USR_PASSWORD"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closePreparedStatement(stmt);
            DBManager.closeConnection(conn);

        }
        return list;

    }

}
