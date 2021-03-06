/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.awt.Robot;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author ISEN
 */
abstract public class Role {
    
    Joueur joueur;
    String camp;
    String nomRole;
    protected VotesJour voteJour = new VoteJourValide();
    protected VotesNuit voteNuit = new VoteNuitNonValide();
    
    public Role(Joueur joueur){
        joueur.rejoindre(this);
        this.joueur=joueur;
        this.camp="";
    }
    
    public String getCamp(){
        return this.camp;
    }
    public int voteNuit(ArrayList<Joueur> joueurs)
    {
        return voteNuit.vote(joueurs);
    }
    
    public int voteJour (ArrayList<Joueur> joueurs)
    {
        return voteJour.vote(joueurs);
    }
    
    public static void repas(ArrayList<Joueur> joueurs)
    {
        float probabilite = (float) Math.random();
        Joueur hote;
        if (probabilite<0.5)
        {
            Bon bonRepas = new Bon(joueurs, probabilite);
            bonRepas.giveAdvantage();
            hote = bonRepas.getHote();
            System.out.println("Le joueur "+hote.getNom()+" à organisé un repas !");
            System.out.println("Il était très bon, son influence augmente.");
        }
        else
        {
            Mauvais repas = new Mauvais(joueurs, probabilite);
            repas.giveDisadvantage();
            hote = repas.getHote();
            System.out.println("Le joueur "+hote.getNom()+" à organisé un repas !");
            System.out.println("Il était mauvais, son influence diminue.");
        }
    }
    
    public static Meteo meteo()
    {
        float probabilite = (float) Math.random();
        Meteo meteo;
        if (probabilite<0.2)
        {
            meteo = new Tempete(probabilite);
        }
        else
        {
            meteo = new BeauTemps(probabilite);
        }
        meteo.afficherTemps();
        return meteo;
    }
    
    public static void attente()
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Appuyez sur \"entrée\" pour continuer");
        reader.nextLine();
    }
    
    public static void fin(String vainqueurs)
    {
        System.out.println("Le camp des "+ vainqueurs + " a battu ses adversaires, la victoire leur appartient !");
        try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("résultats.txt")));
        writer.write("Le camp des "+ vainqueurs + " a gagné.");
        writer.close();
        }
        catch (IOException e)
        {
        e.printStackTrace();
        }
    }
    
    public static String isVainqueur(ArrayList<Joueur> joueurs)
    {
        int nbrLoup = 0;
        int nbrVillageois = 0;
        for (ListIterator<Joueur> iter = joueurs.listIterator(); iter.hasNext(); ) {
            Joueur element = iter.next();
            if (element.getRole().getCamp() == "Villageois")
            {
                nbrVillageois++;
            }
            if (element.getRole().getCamp() == "Loup Garou")
            {
                nbrLoup++;
            }
        }
        if (nbrLoup == 0)
        {
            return "Villageois";
        }
        if (nbrVillageois == 0)
        {
            return "Loups Garous";
        }
        return "None";
    }
    
    public static ArrayList<Joueur> voteDeNuit(ArrayList<Joueur> joueurs)
    {
        int[] tablVote = new int[joueurs.size()+1];
        for (ListIterator<Joueur> iter = joueurs.listIterator(); iter.hasNext(); ) 
        {
            Joueur element = iter.next();
            System.out.println("J'appelle le joueur "+element.getNom());
            attente();
            tablVote[element.getRole().voteNuit.vote(joueurs)]++;
            clear();
        }
        
        int maxI1 = 1;
        int max2 = 0;
        for (int i=2;i<=joueurs.size();i++)
        {
            if (tablVote[maxI1] <= tablVote[i])
            {
                max2 = tablVote[maxI1];
                maxI1 = i;
            }
        }
        if (tablVote[maxI1]==max2)
        {
            System.out.println("Personne n'est mort pendant la nuit.");
            attente();
            return joueurs;
        }
        System.out.println("Le joueur "+joueurs.get(maxI1-1).getNom()+" est mort dévoré par les loups.");
        attente();
        joueurs.remove(maxI1-1);
        return joueurs;
    }
    
    public static ArrayList<Joueur> voteDeJour(ArrayList<Joueur> joueurs)
    {
        int[] tablVote = new int[joueurs.size()+1];
        for (ListIterator<Joueur> iter = joueurs.listIterator(); iter.hasNext(); ) 
        {
            Joueur element = iter.next();
            System.out.println("J'appelle le joueur "+element.getNom()+" à voter.");
            tablVote[element.getRole().voteJour.vote(joueurs)] += element.getForceVote();
            clear();
            
        }
        int maxI1 = 1;
        int max2 = 0;
        for (int i=2;i<=joueurs.size();i++)
        {
            if (tablVote[maxI1] <= tablVote[i])
            {
                max2 = tablVote[maxI1];
                maxI1 = i;
            }
        }
        if (tablVote[maxI1]==max2)
        {
            System.out.println("Personne n'est mort à cause de l'égalité.");
            attente();
            return joueurs;
        }
        System.out.println("Le joueur "+joueurs.get(maxI1-1).getNom()+" est mort pendu par la justice populaire.");
        attente();
        joueurs.remove(maxI1-1);
        return joueurs;
    }
    
    public static ArrayList<Joueur> cycle(ArrayList<Joueur> joueurs)
    {
        Meteo meteo = meteo();
        System.out.println("La nuit tombe.");
        if (meteo.chassePossible())
        {
            System.out.println("Les loups Garous se réveillent.");
            attente();
            System.out.println("Les loups Garous se réendorment dés qu'ils ont fini de choisir leur victime.");
            attente();
            System.out.println("Nous allons passer au petit déjeuner.");
            attente();
            clear();
            joueurs = voteDeNuit(joueurs);
        }
        else
        {
            attente();
            System.out.println("Le jour se lève après la tempète.");
        }
        for (int i=0; i<joueurs.size();i++)
        {
            joueurs.get(i).setForceVote(1);
        }
        repas(joueurs);
        System.out.println("Nous allons passer au vote quotidien.");
        System.out.println("Faites vos délibérations.");
        attente();
        System.out.println("Voici le moment des votes.");
        attente();
        clear();
        joueurs = voteDeJour(joueurs);
        clear();
        return joueurs;
    }
    
    public static void clear()
    {
        try
        {
            if (System.getProperty("os.name").startsWith("Windows")){
                Runtime.getRuntime().exec("cls");
            }
            else{
                Runtime.getRuntime().exec("clear");
            }
        }
        catch(Exception excpt){
            try {
                Robot pressbot = new Robot();
                pressbot.keyPress(17);
                pressbot.keyPress(76);
                pressbot.keyRelease(17);
                pressbot.keyRelease(76); 
                pressbot.keyRelease(17);
                pressbot.keyRelease(76);
                pressbot.keyRelease(17);
                pressbot.keyRelease(76);
                pressbot.keyRelease(17);
                pressbot.keyRelease(76);
            } 
            catch (Exception ex) {
            }
        }
        attente();
    }

    public static ArrayList<Joueur> initialisation(){
        int nbrJoueur=0;
        Scanner reader = new Scanner(System.in);
        System.out.println("Veuillez entrer le nombre de joueur. (minimum 3)");
        String nombreJoueur = reader.nextLine();
        try {
            nbrJoueur = Integer.parseInt(nombreJoueur);
        }
        catch ( NumberFormatException e){
            return initialisation();
        }
        if (Integer.parseInt(nombreJoueur) < 3)
        {
            return initialisation();
        }
        int nbrLoup=nbrJoueur/3;
        System.out.println("Combien voulez vous de loup-garous ? (nombre conseillé :"+nbrLoup+")");
        String nombreLoup = reader.nextLine();
        try {
            nbrLoup = Integer.parseInt(nombreLoup);
        }
        catch (NumberFormatException e ){
            nbrLoup=nbrJoueur/3;
        }
        if (nbrLoup > nbrJoueur/2)
        {
            nbrLoup = nbrJoueur/2;
        }
        int loupRestant = nbrLoup;
        int roleRestant = nbrJoueur;
        ArrayList<Joueur> joueurs = new ArrayList();
        System.out.println("Le nombre de loup-garous a été fixé à: "+nbrLoup);
        attente();
        clear();
        for(int i =0; i<nbrJoueur ;i++){
            System.out.println("J'appelle le joueur numéro : "+(i+1));
            System.out.println("Entrez votre pseudo");
            String nomJoueur = reader.nextLine();
            String joueur ="joueur"+(i+1);
            joueurs.add(new Joueur(nomJoueur));
            
            int nb=(int)(Math.random()*(nbrJoueur)+1);
            if (nb<=nbrLoup && loupRestant!=0){
                joueurs.get(i).rejoindre(new LoupGarou(joueurs.get(i)));
                loupRestant--;
            }
            else{
                if(loupRestant == roleRestant){
                    joueurs.get(i).rejoindre(new LoupGarou(joueurs.get(i)));
                    loupRestant--;
                }
                else{
                    joueurs.get(i).rejoindre(new Villageois(joueurs.get(i)));
                }
            }
            roleRestant--;
            System.out.println("Votre rôle est : "+joueurs.get(i).getRole().nomRole);
            attente();
            clear();
        }
        return joueurs;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Joueur> joueurs = new ArrayList();
        joueurs = initialisation();
        String vainqueur = isVainqueur(joueurs);
        while (vainqueur == "None")
        {
            joueurs = cycle(joueurs);
            vainqueur = isVainqueur(joueurs);
        }
        fin(vainqueur);
    }
    
}
