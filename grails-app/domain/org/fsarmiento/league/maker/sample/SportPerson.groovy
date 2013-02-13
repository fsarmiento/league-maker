package org.fsarmiento.league.maker.sample

class SportPerson {
	
	String person
	
	static belongsTo = [sports:Sport]

    static constraints = {
    }
}
