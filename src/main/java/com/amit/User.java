package com.amit;

public class User {

    private String id; //the new field
    private String name;
    private Integer score;
    private Integer level;
    private Ranking ranking;
    private LearnPath learnPath;

    public User(String id, String name, Integer score, Integer level, Ranking ranking, LearnPath learnPath) {
        super();
        this.id = id;
        this.name = name;
        this.score = score;
        this.level = level;
        this.ranking = ranking;
        this.learnPath = learnPath;
    }
    
    public User(String name, Integer score, Integer level) {
        super();
        this.name = name;
        this.score = score;
        this.level = level;
    }

    public User(String id, String name, Integer score, Integer level) {
        super();
        this.id = id;
        this.name = name;
        this.score = score;
        this.level = level;
    }

    public User(String name, Integer score, Integer level,Ranking ranking, LearnPath learnPath) {
        this.name = name;
        this.score = score;
        this.level = level;
        this.ranking = ranking;
        this.learnPath = learnPath;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Integer getScore() {
        return score;
    }
    public Integer getLevel() {
        return level;
    }
    public Ranking getRanking() {
        return ranking;
    }
    public LearnPath getLearnPath() {
        return learnPath;
    }

}