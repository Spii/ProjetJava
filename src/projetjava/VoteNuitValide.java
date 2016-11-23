package projetjava;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author ISEN
 */
public class VoteNuitValide implements VotesNuit{
    
    public int vote(ArrayList<Joueur> joueurs)
    {
        Scanner reader =new Scanner(System.in);
        System.out.println("0 : Vote blanc");
        for( int i=0; i< joueurs.size() ;i++){
            System.out.println((i+1)+" : "+joueurs.get(i).getNom());
        }
        String joueurId = reader.nextLine();
        return (Integer.parseInt(joueurId));
    }
}
