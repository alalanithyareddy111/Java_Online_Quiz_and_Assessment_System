package model;

public class Question {
    private int id;
    private String question;
    private String[] options;
    private int correct;

    public Question(int id, String question, String[] options, int correct) {
        this.id = id;
        this.question = question;
        this.options = options;
        this.correct = correct;
    }

    public int getCorrect() { return correct; }
    public String getQuestion() { return question; }
    public String[] getOptions() { return options; }
}