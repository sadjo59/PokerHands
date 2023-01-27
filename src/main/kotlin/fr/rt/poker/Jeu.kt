package fr.rt.poker


object Jeu {


    val couleurs = arrayOf(PIQUE, COEUR, CARREAU, TREFLE)

    val hauteurs = arrayListOf<Pair<String,Int>>(
        DEUX,
        TROIS,
        QUATRE,
        CINQ,
        SIX,
        SEPT,
        HUIT,
        NEUF,
        DIX,
        VALET,
        DAME,
        ROI,
        AS,
    )
}

const val TREFLE ="Trèfle"
const val PIQUE = "Pique"
const val COEUR = "Coeur"
const val CARREAU = "Carreau"


val DEUX = Pair("Deux",2);
val TROIS = Pair("Trois",3);
val QUATRE = Pair("Quatre",4);
val CINQ = Pair("Cinq",5);
val SIX = Pair("Six",6);
val SEPT = Pair("Sept",7);
val HUIT = Pair("Huit",8);
val NEUF = Pair("Neuf",9);
val DIX = Pair("Dix",10);
val VALET = Pair("Valet",11);
val DAME = Pair("Dame",12);
val ROI = Pair("Roi",13);
val AS = Pair("As",14);