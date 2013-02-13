package org.fsarmiento.league.maker.domain

class DoublesMatch extends Match {
	
	Team teamA
	
	Team teamB

    static constraints = {
		teamA null: false
		teamB null: false
    }
}
