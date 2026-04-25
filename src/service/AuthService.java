package service;

import java.util.*;
import dao.UserDAO;
import model.User;

public class AuthService {

    Scanner sc = new Scanner(System.in);
    UserDAO userDAO = new UserDAO();

    public String loginOrSignup() throws Exception {

        while (true) {
            System.out.println("\n1. Login as Admin");
            System.out.println("2. Login as User");
            System.out.println("3. Signup");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1 || choice == 2) {

                System.out.print("Username: ");
                String u = sc.nextLine();

                System.out.print("Password: ");
                String p = sc.nextLine();

                String result = userDAO.login(u, p);

                if (result != null) {
                    String[] data = result.split(":");
                    String role = data[1];

                    // 🔐 Validate role matches selection
                    if ((choice == 1 && role.equals("admin")) ||
                        (choice == 2 && role.equals("USER"))) {

                        System.out.println("✅ Login Successful!");
                        return result;

                    } else {
                        System.out.println("❌ Role mismatch!");
                    }

                } else {
                    System.out.println("❌ Invalid credentials");
                }

            } else if (choice == 3) {

                System.out.print("Choose Username: ");
                String u = sc.nextLine();

                System.out.print("Choose Password: ");
                String p = sc.nextLine();

                boolean success = userDAO.register(new User(u, p, "USER"));

                if (success) {
                    System.out.println("✅ Signup Successful!");
                } else {
                    System.out.println("❌ Username already exists.");
                }
            } else {
                System.out.println("Invalid option");
            }
        }
    }
}