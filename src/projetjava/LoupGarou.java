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
    }
    
    @Override
    public int voteNuit(ArrayList<Joueur> joueurs){
        for( int i=0; i< joueurs.size() ;i++){
            if("Loup Garou".equals(joueurs.get(i).getRole().getCamp())){
                joueurs.remove(i);
                i--;
            }
        }
        System.out.println("J'appelle le joueur "+this.joueur.getNom()+" à voter.");
        System.out.println("Appuyer sur entré quand vous êtes prêt à voter.");
        Scanner reader =new Scanner(System.in);
        reader.nextLine();
        System.out.println("0 : Vote blanc");
        for( int i=0; i< joueurs.size() ;i++){
            System.out.println((i+1)+" : "+joueurs.get(i).getNom());
        }
        String joueurId = reader.nextLine();
        return (Integer.parseInt(joueurId)-1);
    }
}
