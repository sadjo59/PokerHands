package fr.rt.poker


import fr.rt.poker.Jeu.couleurs
import fr.rt.poker.Jeu.hauteurs
import java.util.Random

class Carte : Comparable<Carte> {


    private var hauteur : Pair<String,Int>;
    private var couleur : String;

    constructor(){
        this.hauteur = hauteurs[Random().nextInt(hauteurs.size)];
        this.couleur = couleurs[Random().nextInt(couleurs.size)]


    }

    constructor(hauteur :Pair<String,Int>,couleur:String){
        this.hauteur = hauteur;
        this.couleur = couleur;

        if( !hauteurs.contains(hauteur) || !couleurs.contains(couleur)) throw Exception("Card Error")

    }

    override fun compareTo(other: Carte): Int {
       return hauteur.second.compareTo(other.hauteur.second)
    }


    fun getCouleur():String = this.couleur
    fun getHauteur():Int = this.hauteur.second



    override fun toString(): String {
        return "${hauteur.first} de $couleur"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Carte


        return hauteur.second == other.hauteur.second
    }

    override fun hashCode(): Int {
        var result = hauteur.hashCode()
        result = 31 * result + couleur.hashCode()
        return result
    }


}
