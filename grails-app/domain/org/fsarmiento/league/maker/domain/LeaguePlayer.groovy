package org.fsarmiento.league.maker.domain

class LeaguePlayer {
	
	Player player
	
	League league
	
	static belongsTo = [leaguePlayerTeams:LeaguePlayerTeam]

    static constraints = {
    }
}
