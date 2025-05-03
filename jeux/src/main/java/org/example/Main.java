package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner utilisateur = new Scanner(System.in);

        int pc = (int)(Math.random()*21);
        boolean correct = false;
        int counter = 0;

        while (!correct) {
            System.out.println("Veuillez entrer un nombre entre 1 et 20");
            int num_utilisateur = utilisateur.nextInt();

            while (num_utilisateur < 1 || num_utilisateur > 20){
                System.out.println("Nombre entre 1 et 20");
                num_utilisateur = utilisateur.nextInt();
            }

            if (num_utilisateur > pc) {
                System.out.println("Le nombre est plus petit que " + num_utilisateur);
                counter++;
            } else if (num_utilisateur < pc) {
                System.out.println("Le nombre est plus grand que " + num_utilisateur);
                counter++;
            }
            if (num_utilisateur == pc) {
                System.out.println("Nombre " + pc + " trouve en " + counter + " tentatives.");
                correct = true;
            }
        }
    }
}