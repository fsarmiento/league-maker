package org.fsarmiento.league.maker.domain

class Game {
	
	int gameNo;
	
	static belongsTo = [match: Match]

    static constraints = {
		match null: false
    }
}
