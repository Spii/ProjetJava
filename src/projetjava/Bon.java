 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.util.ArrayList;

/**
 *
 * @author ISEN
 */
public class Bon extends Repas{
    
    public Bon(ArrayList<Joueur> joueurs, float probabilite){
        super(joueurs, probabilite);
    }
    public void giveAdvantage(){
        this.hote.setForceVote(2);
    }
}
