/* ***************************************************************************
 * Copyright 2018 Mindstix, Inc.  All rights reserved.
 * -- Mindstix Confidential
 * ***************************************************************************/

package com.elc.learn.model;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User implements Serializable{

    @Id
    private String id;

    private String name;

    private int score;

    private int level;

    public User(){
    
    }
    
    public User(String id){
    	this.id = id;
    }

    public User(String id, String name, int score, int level) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.level = level;
    }

    public User(String name, int score, int level) {
		super();
		this.name = name;
		this.score = score;
		this.level = level;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "User {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score + '\'' +
                ", level=" + level + '\'' +
                '}';
    }
}
