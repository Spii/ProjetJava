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
public class BeauTemps extends Meteo {
    public BeauTemps(){
        super();
    }
     
    @Override
    public void afficherTemps(){
        System.out.println("Il fait beau aujourd'hui, le ciel est dégagée !");
    }
}
