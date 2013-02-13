package org.fsarmiento.league.maker.sample

class Sport {
	
	String name;
	
	static hasMany = [sportPersons:SportPerson]

    static constraints = {
    }
}
