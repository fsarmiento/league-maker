package org.fsarmiento.league.maker.domain

class League {
	
	String name;
	
	static hasMany = [players: LeaguePlayer, teams:Team, matches:Match]

    static constraints = {
		name unique: true
    }
}
