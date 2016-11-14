/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author ISEN
 */
public class LoupGarou extends Role{

    public LoupGarou(Joueur joueur){
        super(joueur);
        this.camp="Loup Garou";
        this.nomRole="Loup Garou";
        this.voteNuit=new VoteNuitValide();
    }
}
