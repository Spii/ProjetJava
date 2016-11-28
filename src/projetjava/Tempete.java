 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author ISEN
 */
public class Tempete extends Meteo {
    public Tempete(float probabilite){
        super(probabilite);
    }
    
    public void afficherTemps(){
    System.out.println("Attention aujourd'hui une tempête traverse le village !");
    }
    
    public boolean chassePossible()
    {
        return false;
    }
}
