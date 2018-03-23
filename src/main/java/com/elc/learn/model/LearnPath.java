/* ***************************************************************************
 * Copyright 2018 Mindstix, Inc.  All rights reserved.
 * -- Mindstix Confidential
 * ***************************************************************************/

package com.elc.learn.model;

import javax.persistence.Column;

public class LearnPath {
    
    private int completed;
 
    private int ongoing;

    private int left;

    private User user;
    
    public LearnPath(int completed, int ongoing, int left, User user) {
        this.completed = completed;
        this.ongoing = ongoing;
        this.left = left;
        this.user = user;
    }

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
