package com.pps.quiz;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UtilisateurService {
    private final Utilisateur utilisateur;

    public UtilisateurService(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void ecrireUnUtilisateurDansUnFichierJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //Même code (juste adapter) s'il s'agissait d'une liste
        
        try (FileWriter filterWriter = new FileWriter("user.json")) {
            gson.toJson(utilisateur, filterWriter);

            System.out.println("Fichier Json écrit avec succès");
        } catch (IOException e) {
            System.err.println("Erreur lors del'écriture " + e.getMessage());
        }
    }

    public void lireUnFichierJson() {
        Gson gson = new Gson();

        try (FileReader lire = new FileReader("user.json")) {
        /*
        Pour lire plusieurs users
        Type typeListe = new TypeToken<List<Utilisateur>>(){}.getType();
        List<Utilisateur> utilisateurs = gson.fromJson(reader, typeListe);
        */
            Utilisateur utilisateur1 = gson.fromJson(lire, Utilisateur.class);

            System.out.println("Nom et prénoms : " + utilisateur1.getNomPrenom());
            System.out.println("Âge : " + utilisateur1.getAge());
            System.out.println("Profession : " + utilisateur1.getProfession());
            System.out.println("Liste des diplômes obtenus : ");

            List<String> diplomes = utilisateur1.getDiplomes();
            for (String diplome : diplomes) {
                System.out.println("\t" + diplome);
            }

        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier Json " + e.getMessage());
        }
    }
}
