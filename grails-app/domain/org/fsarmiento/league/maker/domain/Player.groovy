package org.fsarmiento.league.maker.domain

class Player {
	
	String firstName;
	String lastName;
	String email;
	String codename;

    static constraints = {
		firstName blank: false, nullable: false
		lastName blank: false, nullable: false
		codename blank: false, unique: true
		email email: true, blank: false
    }
}
