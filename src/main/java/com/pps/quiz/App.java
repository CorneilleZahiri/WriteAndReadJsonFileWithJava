package com.pps.quiz;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String reponse;

        do {
            menu();
            reponse = scanner.nextLine();
            Utilisateur utilisateur = new Utilisateur();
            UtilisateurService utilisateurService = new UtilisateurService(utilisateur);

            switch (reponse.charAt(0)) {
                case '1': //Créer un utilisateur
                    System.out.println("Nom et prénoms : ");
                    utilisateur.setNomPrenom(scanner.nextLine());

                    System.out.println("Age : ");
                    utilisateur.setAge(lireEntier(scanner));

                    System.out.println("Profession : ");
                    utilisateur.setProfession(scanner.nextLine());

                    System.out.println("Liste des diplômes séparés par une virgule : ");
                    utilisateur.setDiplomes(Arrays.stream(scanner.nextLine().split(",")).toList());

                    //Ecrire dans le fichier Json
                    utilisateurService.ecrireUnUtilisateurDansUnFichierJson();

                    break;

                case '2':
                    utilisateurService.lireUnFichierJson();
                    System.out.println("Fichier lu avec succès");
                    break;

                default:
                    break;

            }
        } while (!reponse.equals("3"));
    }

    private static void menu() {
        System.out.println("1- Enregistrer un utilisateur dans un fichier Json" +
                "\n2- Lire le fichier Json 'user.json'" +
                "\n3- Quitter");
    }

    private static int lireEntier(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide !");
            }
        }
    }
}
