/* ***************************************************************************
 * Copyright 2018 Mindstix, Inc.  All rights reserved.
 * -- Mindstix Confidential
 * ***************************************************************************/

package com.elc.learn.model;

import javax.persistence.Column;

public class Ranking {

    @Column()
    private int eventsWon;

    @Column()
    private int challengesWon;

    public Ranking(int eventsWon, int challengesWon) {
        this.eventsWon = eventsWon;
        this.challengesWon = challengesWon;
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
