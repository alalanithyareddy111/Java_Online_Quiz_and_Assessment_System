package db;
import java.sql.*;



public class DBConnection {
	public static Connection getConnection() throws Exception {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		// System.out.println("Driver loaded!");
        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");
//        System.out.println("URL: " + url);
//        System.out.println("USER: " + user);
//        System.out.println("PASS: " + password);
        return DriverManager.getConnection(url, user, password);
    }
}
