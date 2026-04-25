package dao;

import db.DBConnection;
import model.Question;

import java.sql.*;
import java.util.*;

public class QuestionDAO {

    public List<Question> getAllQuestions() throws Exception {
        List<Question> list = new ArrayList<>();

        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM questions");

        while (rs.next()) {
            String[] options = {
                rs.getString("option1"),
                rs.getString("option2"),
                rs.getString("option3"),
                rs.getString("option4")
            };

            list.add(new Question(
                rs.getInt("id"),
                rs.getString("question"),
                options,
                rs.getInt("correct")
            ));
        }

        return list;
    }

    public void addQuestion(String q, String o1, String o2, String o3, String o4, int correct) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO questions(question, option1, option2, option3, option4, correct) VALUES (?, ?, ?, ?, ?, ?)"
        );

        ps.setString(1, q);
        ps.setString(2, o1);
        ps.setString(3, o2);
        ps.setString(4, o3);
        ps.setString(5, o4);
        ps.setInt(6, correct);

        ps.executeUpdate();
    }
    public boolean deleteQuestion(int id) throws Exception {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM questions WHERE id = ?"
        );

        ps.setInt(1, id);

        return ps.executeUpdate() > 0;
    }
}