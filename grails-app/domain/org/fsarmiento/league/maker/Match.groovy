package org.fsarmiento.league.maker

class Match {
	
	Team teamA
	
	Team teamB
	
	static belongsTo = [league:League]

    static constraints = {
		teamA null: false
		teamB null: false
    }
}
