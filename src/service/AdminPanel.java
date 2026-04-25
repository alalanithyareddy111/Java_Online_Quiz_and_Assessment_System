package service;
import java.util.*;
import dao.QuestionDAO;
public class AdminPanel {
	public void adminPanel() throws Exception {
	    Scanner sc = new Scanner(System.in);
	    QuestionDAO dao = new QuestionDAO();

	    while (true) {
	        System.out.println("\n=== ADMIN PANEL ===");
	        System.out.println("1. Add Question");
	        System.out.println("2. Delete Question");
	        System.out.println("3. Exit");

	        int choice = sc.nextInt();
	        sc.nextLine();

	        if (choice == 1) {
	            System.out.print("Question: ");
	            String q = sc.nextLine();

	            System.out.print("Option1: ");
	            String o1 = sc.nextLine();

	            System.out.print("Option2: ");
	            String o2 = sc.nextLine();

	            System.out.print("Option3: ");
	            String o3 = sc.nextLine();

	            System.out.print("Option4: ");
	            String o4 = sc.nextLine();

	            System.out.print("Correct (1-4): ");
	            int c = sc.nextInt();

	            dao.addQuestion(q, o1, o2, o3, o4, c);
	            System.out.println("✅ Question Added");
	        } 
	        else if (choice == 2) {
	            System.out.print("Enter Question ID to delete: ");
	            int id = sc.nextInt();

	            boolean deleted = dao.deleteQuestion(id);

	            if (deleted) {
	                System.out.println("✅ Question deleted");
	            } else {
	                System.out.println("❌ Question not found");
	            }
	        }
	        else {
	            break;
	        }
	    }
	}
}

