 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author ISEN
 */
abstract public class Meteo extends Evenemment {    
    public Meteo(float probabilite){
        super(probabilite);
    }    
    abstract public void afficherTemps();
    abstract public boolean chassePossible();
}
