package org.fsarmiento.league.maker.domain

class Team {
	
	String name;
	
	static belongsTo = [league:League, leaguePlayerTeams:LeaguePlayerTeam]

    static constraints = {
		name unique: true
    }
}
