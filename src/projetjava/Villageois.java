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
public class Villageois extends Role{
    
    public Villageois(Joueur joueur){
        super(joueur);
        this.nomRole="Villageois";
        this.camp="Villageois";
    }
    
    public int voteNuit(ArrayList <Joueur> joueurs){
        System.out.println("Error villageois can't voteNuit.");
        return -1;
    }
}
