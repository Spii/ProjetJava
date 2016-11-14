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
public class Tempete extends Meteo {
    public Tempete(){
        super();
    }
    
    @Override
    public void afficherTemps(){
    System.out.println("Attention aujourd'hui une tempête traverse le village !!!");
}
}
