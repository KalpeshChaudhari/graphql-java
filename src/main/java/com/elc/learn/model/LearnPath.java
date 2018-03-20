/* ***************************************************************************
 * Copyright 2018 Mindstix, Inc.  All rights reserved.
 * -- Mindstix Confidential
 * ***************************************************************************/

package com.elc.learn.model;

import javax.persistence.Column;

public class LearnPath {
    
    @Column()
    private int completed;
    
    @Column()
    private int ongoing;
    
    @Column()
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
