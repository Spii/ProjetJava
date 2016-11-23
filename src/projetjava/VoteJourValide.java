/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author ISEN
 */
public class VoteJourValide implements VotesJour{
    
    public int vote(ArrayList<Joueur> joueurs){
        System.out.println("Appuyer sur entré quand vous êtes prêt à voter.");
        Scanner reader =new Scanner(System.in);
        reader.nextLine();
        System.out.println("0 : Vote blanc");
        for( int i=0; i< joueurs.size() ;i++){
            System.out.println((i+1)+" : "+joueurs.get(i).getNom());
        }
        String joueurId = reader.nextLine();
        return (Integer.parseInt(joueurId));     
    }
}
