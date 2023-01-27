package fr.rt.poker

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class CarteTest {

    @Test
    fun compareTo() {

        assertTrue(Carte(TROIS, PIQUE) == Carte(TROIS, CARREAU))
        assertTrue(Carte(CINQ, PIQUE) > Carte(TROIS, CARREAU))
        assertFalse(Carte(AS, COEUR) < Carte(ROI, COEUR))
    }

}