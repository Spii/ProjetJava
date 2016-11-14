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
        System.out.println("Vous n'êtes pas loup et vous ne pouvez pas voter ce soir");
        System.out.println("Merci d'entrer le chiffre "+alea (à foutre en str)+" pour simuler un vote");
        Scanner reader = new Scanner(System.in);
        String vote = reader.nextLine();
        while (vote!=alea)
        return (-1);     
    }
}

