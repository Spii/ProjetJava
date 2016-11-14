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
public class Joueur {
    private String nom;
    private Role role;
    private int forceVote;
    
    public Joueur(){
        this.nom= "Joueur1";
        this.role= null;
        this.forceVote = 1;
    }
    
    public Joueur(String nom){
        this.nom = nom;
        this.role = null;
       }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setRole(Role role){
        this.role = role;
    }
    public void setForceVote(int forceVote){
        this.forceVote=forceVote;
    }
    public String getNom(){
        return this.nom;
    }
    public Role getRole(){
        return this.role;
    }
    
    public void rejoindre(Role role){
        this.setRole(role);
    }
    public void quitter(Joueur joueur,ArrayList<Joueur> joueurs){
        System.out.println("Le joueur "+this.nom+" nous a quitté");
        for(int i=0;i<joueurs.size();i++){
            if(joueurs.get(i).nom.equals(this.nom)){
                joueurs.remove(i);
            }
        }
    }
}
