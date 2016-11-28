 

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
abstract public class Repas extends Evenemment{
    Joueur hote;
    
    public Repas (ArrayList<Joueur> joueurs, float probabilite){
        super(probabilite);
        this.hote = joueurs.get((int)(Math.random()*joueurs.size()));
    }
    public Joueur getHote(){
        return this.hote;
    }
}
