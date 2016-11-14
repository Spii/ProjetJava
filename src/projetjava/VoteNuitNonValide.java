package projetjava;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author ISEN
 */
public class VoteNuitNonValide implements VotesNuit{
    
    public int vote(ArrayList<Joueur> joueurs){
        System.out.println("Ce joueur ne peux pas voter");
        return (-1);     
    }
}

