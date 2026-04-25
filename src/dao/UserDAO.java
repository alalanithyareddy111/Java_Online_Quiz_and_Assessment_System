package dao;

import db.DBConnection;
import model.User;

import java.sql.*;

public class UserDAO {

    // SIGNUP
    public boolean register(User user) throws Exception {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO users(username, password, role) VALUES (?, ?, ?)"
        );

        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getRole());   // ✅ FIX

        return ps.executeUpdate() > 0;
    }

    // LOGIN
    public String login(String username, String password) throws Exception {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT id, role FROM users WHERE username=? AND password=?"
        );

        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt("id") + ":" + rs.getString("role"); // ✅ FIX
        }

        return null;
    }
}