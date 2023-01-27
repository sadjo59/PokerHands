package fr.rt.poker

class Hand : Comparable<Hand> {

    private var cartes = arrayOf<Carte>()

    private var score :Int = 0

    constructor(cartes:Array<Carte> ){
       this.cartes = cartes
        this.cartes.sort()
        score = calculScore()

    }

    constructor(carteUn :Carte,carteDeux :Carte,carteTrois :Carte,carteQuatre :Carte,carteCinq :Carte){
        this.cartes += carteUn;
        this.cartes += carteDeux;
        this.cartes += carteTrois;
        this.cartes += carteQuatre;
        this.cartes += carteCinq;
        this.cartes.sort()

        score = calculScore()

    }

    fun getScore()=score

    fun carteHaute():Int{

        var scoreCards =0

        for (carte in cartes){

            scoreCards += carte.getHauteur()

        }

        return scoreCards
    }

    fun calculScore():Int{
        if(this.isQuinteFlush())
            return 9000 + carteHaute()
        if(this.isCarree())
            return 8000 + carteHaute()
        if(this.isFull())
            return 7000 + cartes.get(2).getHauteur()
        if(this.isCouleur())
            return 6000 + carteHaute()
        if(this.isQuinte())
            return 5000 + carteHaute()
        if(this.isBrelan())
            return 4000 + cartes.get(2).getHauteur()


        return carteHaute()

    }

    fun isBrelan():Boolean{

        var hauteurBrelan = cartes.get(2).getHauteur()
        var cpt=0

        for (carte in cartes){
            if(carte.getHauteur() == hauteurBrelan)
                cpt++
        }
        return cpt == 3
    }


    fun isCarree():Boolean{

        var hauteurCarree = cartes.get(2).getHauteur()
        var cpt=0

        for (carte in cartes){
            if(carte.getHauteur() == hauteurCarree)
                cpt++
        }
        return cpt == 4
    }

    fun isQuinte():Boolean{

        for (i in 1 until 5){
            if(cartes[i].getHauteur() != (cartes[i-1].getHauteur()+1)) return false
        }
        return true;
    }

    fun isCouleur():Boolean{
        val couleurTest = cartes.get(0).getCouleur()

        for(carte in cartes){
            if(!carte.getCouleur().contains(couleurTest)) return false
        }
        return true

    }

    fun isQuinteFlush():Boolean{
       return (isCouleur() && isQuinte())
    }

    fun isFull():Boolean{


        if(isBrelan()){
            var tmpCartes = cartes.filter { it.getHauteur() != cartes.get(2).getHauteur() }

            if(tmpCartes.get(0).getHauteur() == tmpCartes.get(1).getHauteur())
                return true;
        }

        return false;



    }


    override fun compareTo(other: Hand): Int {
        return score.compareTo(other.score)
    }




    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Hand

        if (score != other.score) return false

        return true
    }

    override fun hashCode(): Int {
        var result = cartes.hashCode()
        result = 31 * result + score
        return result
    }

    override fun toString(): String {
        return "Hand(cartes=${cartes.contentToString()})"
    }



}