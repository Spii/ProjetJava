/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

/**
 *
 * @author ISEN
 */
abstract public class Meteo extends Evenemment {
    int duree;
    
    public Meteo(){
        super();
        this.duree =(int)(Math.random()*2+1);
    }    
    abstract public void afficherTemps();
}
