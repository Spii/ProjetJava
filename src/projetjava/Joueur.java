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
public class Joueur {
    private String nom;
    private Role role;
    
    public Joueur(){
        this.nom= "Joueur1";
        this.role= null;
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
    public String getNom(){
        return this.nom;
    }
    public Role getRole(){
        return this.role;
    }
    
    public void rejoindre(Role role){
        this.setRole(role);
    }
    public void quitter(Joueur joueur){
        // à completer
    }
}
