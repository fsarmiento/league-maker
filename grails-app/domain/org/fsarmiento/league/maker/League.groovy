package org.fsarmiento.league.maker

class League {
	
	String name;
	
	static hasMany = [teams:Team, matches:Match]

    static constraints = {
		name unique: true
    }
}
