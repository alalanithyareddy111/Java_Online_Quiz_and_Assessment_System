package dao;

import db.DBConnection;
import model.Result;

import java.sql.*;

public class ResultDAO {

    public void saveResult(Result result) throws Exception {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO results(user_id, score, total) VALUES (?, ?, ?)"
        );

        ps.setInt(1, result.getUserId());
        ps.setInt(2, result.getScore());
        ps.setInt(3, result.getTotal());

        ps.executeUpdate();
    }
}