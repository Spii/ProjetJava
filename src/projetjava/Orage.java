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
public class Orage extends Meteo{
    public Orage(){
        super();
    }
    
    @Override
    public void afficherTemps(){
        System.out.println("Attention un Orage est prévue pour cette nuit !");
    }
}
