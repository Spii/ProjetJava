 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

public class BeauTemps extends Meteo {
    public BeauTemps(float probabilite){
        super(probabilite);
    }
    public void afficherTemps(){
        System.out.println("Il fait beau aujourd'hui, le ciel est dégagée.");
    }
    
    public boolean chassePossible()
    {
        return true;
    }
}
