//package service;
//
//import dao.QuestionDAO;
//import dao.ResultDAO;
//import model.Question;
//import model.Result;
//
//import java.util.*;
//
//public class QuizService {
//
//    public void startQuiz(int userId) throws Exception {
//
//        Scanner sc = new Scanner(System.in);
//        QuestionDAO qdao = new QuestionDAO();
//        ResultDAO resultDAO = new ResultDAO();
//
//        List<Question> questions = qdao.getAllQuestions();
//
//        int score = 0;
//        long QUIZ_TIME_LIMIT = 60; // seconds
//        long startTime = System.currentTimeMillis();
//
//        for (Question q : questions) {
//
//            long elapsed = (System.currentTimeMillis() - startTime) / 1000;
//
//            if (elapsed > QUIZ_TIME_LIMIT) {
//                System.out.println("\n⏰ Time's up!");
//                break;
//            }
//
//            System.out.println("\n" + q.getQuestion());
//
//            String[] opts = q.getOptions();
//            for (int i = 0; i < opts.length; i++) {
//                System.out.println((i + 1) + ". " + opts[i]);
//            }
//
//            System.out.print("Your answer: ");
//            int ans = sc.nextInt();
//
//            if (ans-1 == q.getCorrect()) {
//                score++;
//            }
//        }
//
//        // Save result
//        resultDAO.saveResult(new Result(userId, score, questions.size()));
//
//        // Display result
//        System.out.println("\n✅ Quiz Finished!");
//        System.out.println("Score: " + score + "/" + questions.size());
//
//        if (score > questions.size() / 2) {
//            System.out.println("Performance: Good 👍");
//        } else {
//            System.out.println("Performance: Needs Improvement 📚");
//        }
//    }
//}




package service;

import dao.QuestionDAO;
import dao.ResultDAO;
import model.Question;
import model.Result;

import java.util.*;

public class QuizService {

    public void startQuiz(int userId) throws Exception {

        Scanner sc = new Scanner(System.in);
        QuestionDAO qdao = new QuestionDAO();
        ResultDAO resultDAO = new ResultDAO();

        List<Question> questions = qdao.getAllQuestions();

        int score = 0;
        long QUIZ_TIME_LIMIT = 60; // seconds
        long startTime = System.currentTimeMillis();

        System.out.println("\n🎯 Quiz Started!");

        for (Question q : questions) {

            long elapsed = (System.currentTimeMillis() - startTime) / 1000;
            long remaining = QUIZ_TIME_LIMIT - elapsed;

            // ⏰ Timer check
            if (remaining <= 0) {
                System.out.println("\n⏰ Time's up!");
                break;
            }

            // ⏳ Show remaining time
            System.out.println("\n⏳ Time left: " + remaining + " sec");

            // ❓ Display question
            System.out.println(q.getQuestion());

            String[] opts = q.getOptions();
            for (int i = 0; i < opts.length; i++) {
                System.out.println((i + 1) + ". " + opts[i]);
            }

            System.out.print("Your answer (1-4): ");
            int ans = sc.nextInt();

            // ✅ Fix index issue
            if (ans - 1 == q.getCorrect()) {
                score++;
            }
        }

        // ✅ Save result to DB
        resultDAO.saveResult(new Result(userId, score, questions.size()));
        System.out.println("DEBUG: Result saved successfully");

        // 📊 Display result
        System.out.println("\n✅ Quiz Finished!");
        System.out.println("Score: " + score + "/" + questions.size());

        double percentage = (score * 100.0) / questions.size();
        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 70) {
            System.out.println("Performance: Excellent 🌟");
        } else if (percentage >= 50) {
            System.out.println("Performance: Good 👍");
        } else {
            System.out.println("Performance: Needs Improvement 📚");
        }
    }
}