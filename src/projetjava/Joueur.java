 

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
    public int getForceVote(){
        return this.forceVote;
    }
    
    public void rejoindre(Role role){
        this.setRole(role);
    }
}
