package org.fsarmiento.league.maker

class Player {
	
	String firstName;
	String lastName;
	String email;
	String codename;

    static constraints = {
		codename unique: true
    }
}
