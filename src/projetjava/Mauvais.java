/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import java.util.ArrayList;

/**
 *
 * @author ISEN
 */
public class Mauvais extends Repas{
    
    public Mauvais(ArrayList<Joueur> joueurs){
        super(joueurs);
    }
    public void giveDisadvantage(){
        int nb =(int)(Math.random()*(this.participant.size())+1);
        int force = 0;
        this.participant.get(nb).setForceVote(force);
    }
}
