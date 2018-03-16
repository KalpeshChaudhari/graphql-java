/* ***************************************************************************
 * Copyright 2018 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * ***************************************************************************
 * $Author$ $Id$ $DateTime$
 * ***************************************************************************/

package com.amit;

public class Ranking {

    private int eventsWon;

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
