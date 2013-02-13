package org.fsarmiento.league.maker.domain

class SinglesMatch extends Match {
	
	Player playerA
	
	Player playerB

    static constraints = {
		playerA null: false
		playerB null: false
    }
}
