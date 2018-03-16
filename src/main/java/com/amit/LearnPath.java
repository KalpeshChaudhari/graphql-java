package com.amit;

public class LearnPath {

    private int completed;
    
    private int ongoing;
    
    private int left;

    public LearnPath(int completed, int ongoing, int left) {
        this.completed = completed;
        this.ongoing = ongoing;
        this.left = left;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getOngoing() {
        return ongoing;
    }

    public void setOngoing(int ongoing) {
        this.ongoing = ongoing;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }
}
