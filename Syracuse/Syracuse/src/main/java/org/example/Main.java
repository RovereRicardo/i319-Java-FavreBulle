package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Variables restart
        boolean restart = false;  // On  appelle ça d'une "flag" pour commencer ou termine la boucle while 

        //Demander nombre entier positif
        Scanner nombre = new Scanner(System.in); //Ouvrir le scanner pour l'input utilisateur
        System.out.println("Entrez un nombre entier positif : "); //Message d'affichage pour informe l'utilisateur
        int nombreUtilisaeur = nombre.nextInt(); // Sauvegarder le nombre donne par l'user [int pour force le nombre a entier]

        //Verification du nombre
        if (nombreUtilisaeur <= 0) { //Si nombre est egal ou plus petit que 0
            System.out.println("Nombre invalide, veuillez entrer un nombre positif : "); //Affiche message d'erreur
            nombreUtilisaeur = nombre.nextInt(); // Redemander a l'utilisateur le nombre
        }

        //Evaluation des conditions
        while (!restart) { // Tant que restart est faux
            if (nombreUtilisaeur % 2 == 0) { // Si nombre pair
                nombreUtilisaeur /= 2; //Divise le nombre par 2

            } else if (nombreUtilisaeur % 2 == 1) { // Si nombre impair
                nombreUtilisaeur = (nombreUtilisaeur * 3) + 1; // Multiple le nombre par 3 et on ajoute 1
            }
            //Affichage
            System.out.print(nombreUtilisaeur + ", "); // Pour l'affichage

            // Demander de recommencer ou finir
            if (nombreUtilisaeur == 1) { // Si le nombre est 1 le reste du result est toujour le meme donc 1 2 4 1 2 4 1 2 4 etc
                System.out.println("Voulez-vous recommencer ? [O/N] (Oui / Non) :"); // Message pour l'utilisateur

                Scanner inputRecommencer = new Scanner(System.in); // Ouvrir le scanner pour l'input
                String recommencer = inputRecommencer.nextLine().toUpperCase(); // Sauvergarde la reponse [toUpperCase() pour assure lettre majuscule

                //Verification
                if (recommencer.equals("N")) { //Si reposnse "N"
                    System.out.println("Au revoir"); // Message affiche
                    restart = true; // On tourne la flag en true pour arreter la boucle while
                } else if (recommencer.equals("O")) { //Si reponse "O"
                    System.out.println("Entrez un nombre entier positif : "); //Demande une nombre a nouveau
                    nombreUtilisaeur = nombre.nextInt(); //Sauvegarde l'input d'utilisateur
                }
            }
        }
    }
}