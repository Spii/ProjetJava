/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import java.util.ArrayList;
/**
 *
 * @author ISEN
 */
public interface vote {
    public int voteJour(ArrayList<Joueur> joueurs);
    public int voteNuit(ArrayList <Joueur> joueurs);
}
