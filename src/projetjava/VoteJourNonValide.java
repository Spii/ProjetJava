 

 
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
/**
 *
 * @author ISEN
 */
public class VoteJourNonValide implements VotesJour{
    
    public int vote(ArrayList<Joueur> joueurs){
        System.out.println("Vous n'êtes pas éligible au vote journalier.");
        return (0);  
    }
}
