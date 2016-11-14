/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ISEN
 */
abstract class Role {
    
    Joueur joueur;
    String camp;
    String nomRole;
    protected VotesJour voteJour = new VoteJourValide();
    protected VotesNuit voteNuit = new VoteNuitNonValide();
    
    public Role(Joueur joueur){
        joueur.rejoindre(this);
        this.joueur=joueur;
        this.camp="";
    }
    
    public String getCamp(){
        return this.camp;
    }
    public int voteNuit(ArrayList<Joueur> joueurs)
    {
        return voteNuit.vote(joueurs);
    }
    
    public int voteJour (ArrayList<Joueur> joueurs)
    {
        return voteJour.vote(joueurs);
    }
}
