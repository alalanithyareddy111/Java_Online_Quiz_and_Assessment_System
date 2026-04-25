package model;

public class Result {
    private int userId;
    private int score;
    private int total;

    public Result(int userId, int score, int total) {
        this.userId = userId;
        this.score = score;
        this.total = total;
    }

    public int getUserId() { return userId; }
    public int getScore() { return score; }
    public int getTotal() { return total; }
}