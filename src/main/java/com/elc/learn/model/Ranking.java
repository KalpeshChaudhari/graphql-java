/* ***************************************************************************
 * Copyright 2018 Mindstix, Inc.  All rights reserved.
 * -- Mindstix Confidential
 * ***************************************************************************/

package com.elc.learn.model;

import javax.persistence.Column;

public class Ranking {

    private int eventsWon;

    private int challengesWon;

    private User user;
    
    public Ranking() {
    }
    
    public Ranking(int eventsWon, int challengesWon, User user) {
        this.eventsWon = eventsWon;
        this.challengesWon = challengesWon;
        this.user = user;
    }

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getEventsWon() {
        return eventsWon;
    }

    public void setEventsWon(int eventsWon) {
        this.eventsWon = eventsWon;
    }

    public int getChallengesWon() {
        return challengesWon;
    }

    public void setChallengesWon(int challengesWon) {
        this.challengesWon = challengesWon;
    }

}
