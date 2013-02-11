package org.fsarmiento.league.maker

class Team {
	
	String name;
	
	static hasMany = [players:Player]
	
	static belongsTo = [league:League]

    static constraints = {
		name unique: true
    }
}
