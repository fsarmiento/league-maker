package org.fsarmiento.league.maker.domain



import grails.test.mixin.*

import org.fsarmiento.league.maker.domain.*;
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(LeaguePlayer)
class LeaguePlayerTests extends GroovyTestCase {
	
    void testSomething() {
       LeaguePlayer player = new LeaguePlayer(fistName: 'myFirst',
		   lastName: 'myLast', codename: 'myCode', email: 'myemail@test.com');
	   player.save(flush: true)
	   
	   assertEquals 1, LeaguePlayer.list().length()
	   
//	   def players = LeaguePlayer.list()
//	   assertNotNull players
	   
//	   def onlyPlayer = LeaguePlayer.get(1)
//	   assertNotNull onlyPlayer
//	   assertEquals onlyPlayer.firstName 'myFirst'
    }
	
}
