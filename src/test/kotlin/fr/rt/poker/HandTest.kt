package fr.rt.poker

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class HandTest {

    var highQuinteFlushPique = Hand(Carte(DIX, PIQUE),Carte(VALET, PIQUE),Carte(DAME, PIQUE),Carte(ROI, PIQUE),Carte(AS, PIQUE))
    var highQuinteFlushCarreau = Hand(Carte(DIX, CARREAU),Carte(VALET, CARREAU),Carte(DAME, CARREAU),Carte(ROI, CARREAU),Carte(AS, CARREAU))
    var lowQuinteFlushCoeur = Hand(Carte(QUATRE, COEUR),Carte(CINQ, COEUR),Carte(SIX, COEUR),Carte(SEPT, COEUR),Carte(HUIT, COEUR))

    var highCouleurCoeur = Hand(Carte(SEPT, COEUR),Carte(DIX, COEUR),Carte(VALET, COEUR),Carte(DAME, COEUR),Carte(AS, COEUR))
    var highCouleurPique = Hand(Carte(SEPT, PIQUE),Carte(DIX, PIQUE),Carte(VALET, PIQUE),Carte(DAME, PIQUE),Carte(AS, PIQUE))
    var lowCouleurTrefle = Hand(Carte(DEUX, TREFLE),Carte(QUATRE, TREFLE),Carte(SIX, TREFLE),Carte(SEPT, TREFLE),Carte(HUIT, TREFLE))

    var highQuinte = Hand(Carte(DIX, COEUR),Carte(VALET, PIQUE),Carte(DAME, CARREAU),Carte(ROI, TREFLE),Carte(AS, CARREAU))
    var lowQuinte = Hand(Carte(QUATRE, CARREAU),Carte(CINQ, COEUR),Carte(SIX, PIQUE),Carte(SEPT, TREFLE),Carte(HUIT, COEUR))


    var septCarree = Hand(Carte(SEPT, TREFLE),Carte(DEUX, TREFLE),Carte(SEPT, COEUR),Carte(SEPT, PIQUE),Carte(SEPT, CARREAU))
    var cinqCarree = Hand(Carte(CINQ, TREFLE),Carte(TROIS, PIQUE),Carte(CINQ, COEUR),Carte(CINQ, PIQUE),Carte(CINQ, CARREAU))

    var septBrelan = Hand(Carte(SEPT, TREFLE),Carte(DEUX, TREFLE),Carte(SEPT, COEUR),Carte(SEPT, PIQUE),Carte(QUATRE, CARREAU))
    var cinqBrelan = Hand(Carte(CINQ, TREFLE),Carte(TROIS, PIQUE),Carte(CINQ, COEUR),Carte(CINQ, PIQUE),Carte(NEUF, CARREAU))

    var highFull = Hand(Carte(AS, TREFLE),Carte(TROIS, PIQUE),Carte(AS, COEUR),Carte(TROIS, PIQUE),Carte(AS, CARREAU))
    var lowFull = Hand(Carte(CINQ, TREFLE),Carte(TROIS, PIQUE),Carte(CINQ, COEUR),Carte(CINQ, PIQUE),Carte(TROIS, CARREAU))





    @Test
    fun testIsQuinteFlush(){


      assertTrue(highQuinteFlushCarreau == highQuinteFlushPique)
      assertTrue(highQuinteFlushCarreau > lowQuinteFlushCoeur)
      assertFalse(highQuinteFlushCarreau < highQuinteFlushPique)
      assertFalse(highQuinteFlushCarreau < lowQuinteFlushCoeur)

    }

    @Test
    fun testQuinte(){

        assertTrue(lowQuinteFlushCoeur > highQuinte)

        assertTrue(highQuinte > lowQuinte)
        assertTrue(highQuinte == highQuinte)

    }

    @Test
    fun testCouleur(){

        assertTrue(highQuinte < lowCouleurTrefle)

        assertTrue(highCouleurCoeur == highCouleurPique)
        assertTrue(highCouleurPique > lowCouleurTrefle)
    }

    @Test
    fun isCarree(){

        assertTrue(septCarree > cinqCarree)
        assertTrue(septCarree < lowQuinteFlushCoeur)
        assertTrue(cinqCarree > lowCouleurTrefle)
        assertTrue(septCarree > highQuinte)
    }

    @Test
    fun isBrelan(){

        assertTrue(septBrelan > cinqBrelan)
        assertTrue(septBrelan < septCarree)

    }

    @Test
    fun isFull(){
        assertTrue(lowFull < lowQuinteFlushCoeur)
        assertTrue(lowFull < cinqCarree)
        assertTrue(highFull > lowFull)
        assertTrue(lowFull > highQuinte)
        assertTrue(highFull > septBrelan)
    }
}