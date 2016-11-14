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
abstract public class Repas extends Evenemment{
    String hote;
    ArrayList<Joueur> participant;
    
    public Repas (ArrayList<Joueur> joueurs){
        super();
        Joueur joueurHote=joueurs.get((int)(Math.random()*(joueurs.size())+1));
        setHote(joueurHote);
        setParticipant(joueurs);
    }
    public void setHote(Joueur joueurHote){
        this.hote = joueurHote.getNom();
    }
    public void setParticipant(ArrayList<Joueur> joueurs){
        int nb =(int)(Math.random()*(joueurs.size())+1);
        ArrayList<Joueur> copie = joueurs;
        for (int i =0; i<nb; i++){
            int j=(int)(Math.random()*(copie.size())+1);
            this.participant.add(copie.get(j));
            copie.remove(j);
        }
    }
}
