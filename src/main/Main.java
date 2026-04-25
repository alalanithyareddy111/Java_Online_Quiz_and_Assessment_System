//package main;
//import service.QuizService;
//import service.AuthService;
//import service.AdminPanel;
//public class Main {
//    public static void main(String[] args) throws Exception {
//
//        AuthService auth = new AuthService();
//        QuizService quiz = new QuizService();
//        AdminPanel panel=new AdminPanel();
//        String loginData = auth.loginOrSignup();
//
//        String[] parts = loginData.split(":");
//        int userId = Integer.parseInt(parts[0]);
//        String role = parts[1];
//
//        if (role.equalsIgnoreCase("admin")) {
//            panel.adminPanel();
//        } else {
//            quiz.startQuiz(userId);
//        }
//    }
//}


package main;

import service.QuizService;
import service.AuthService;
import service.AdminPanel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        AuthService auth = new AuthService();
        QuizService quiz = new QuizService();
        AdminPanel panel = new AdminPanel();

        while (true) {   // 🔁 full app loop

            String loginData = auth.loginOrSignup();

            String[] parts = loginData.split(":");
            int userId = Integer.parseInt(parts[0]);
            String role = parts[1];

            if (role.equalsIgnoreCase("admin")) {

                panel.adminPanel();

            } else {

                while (true) {   // 🔁 quiz retry loop

                    quiz.startQuiz(userId);

                    System.out.println("\n1. Retry Quiz");
                    System.out.println("2. Logout");

                    int choice = sc.nextInt();

                    if (choice == 2) {
                        System.out.println("🔓 Logged out!");
                        break;
                    }
                }
            }
        }
    }
}