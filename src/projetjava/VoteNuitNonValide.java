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
        String alea = String.valueOf((int) (Math.random()*10));
        System.out.println("Vous n'êtes pas loup et vous mangez des fruits au petit déj.");
        System.out.println("Merci d'entrer le chiffre "+alea+" pour manger votre mandarine.");
        Scanner reader = new Scanner(System.in);
        String vote = reader.nextLine();
        while (vote.equals(alea) == false)
        {
            vote = reader.nextLine();
        }  
        return (0);
    }
}