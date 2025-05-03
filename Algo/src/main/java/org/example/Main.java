package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Saisir un nombre entre 1 et 12 inclus : ");
        Scanner inValue = new Scanner(System.in);
        int n = inValue.nextInt();

            while(n <= 0 || n > 12) {
                System.out.println("Nombre entre 1 et 12 inclus : ");
                try {
                    n = inValue.nextInt();
                } catch (Exception e) {
                    System.out.println("Nombre doit etre entre 1 et 12 et entier : " + e);
                }
            }

            if (n > 0 && n <= 12) {
                for (int i = 1; i <= n; i++) {
                    System.out.print(i + "*" + n + "=" + i * n + "\n");
                }
            }
        }
}


/*
Ecrire un algo:
Qui demande a l utilisateur de saisir en console un nombre imperativement compris entre 1 et 12 inclus

Ensuit d afficher le message "Vous avez choisi la table de multiplication de: " avec le nombre saisi par l utilisateur

Pour terminer afficher la table de multiplication de 1 a 12 du nombre saisi selon modele ci decu

 */