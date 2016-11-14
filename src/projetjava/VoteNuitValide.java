package projetjava;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author ISEN
 */
public class VoteNuitValide implements VotesNuit{
    
    public int vote(ArrayList<Joueur> joueurs){
        for( int i=0; i< joueurs.size() ;i++){
            if("Loup Garou".equals(joueurs.get(i).getRole().getCamp())){
                joueurs.remove(i);
                i--;
            }
        }
        System.out.println("J'appelle le joueur "+this.+" à voter.");
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
