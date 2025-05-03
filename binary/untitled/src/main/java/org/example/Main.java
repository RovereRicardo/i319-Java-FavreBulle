package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Decimal pour Binary
            Scanner input = new Scanner(System.in); //Initialisation du scanner pour la saisie du nombre décimal
            System.out.print("Entrez un nombre decimal: "); //Message pour l'utilisateur
            int number = input.nextInt(); //Sauvegarde de l'entrée utilisateur

            List<Integer> binary = new ArrayList<>(); //Initialisation d'une List<ArrayList> : la différence par rapport au tableau [] est que la List<ArrayList> a une taille illimitée

            while(number > 0) { //Tant que le nombre est supérieur à 0
                binary.add(number % 2); // Ajoutez à la liste le résultat de nombre % 2.
                number = number / 2; // Diviser le nombre par 2 et remplacer sa valeur
            }
            binary = binary.reversed(); // Inverser le tableau

            System.out.println("Le nombre binaire est: " + binary); // Message avec la convertion

        //Binary pour Decimal
            Scanner inputBinary = new Scanner(System.in); //Initialisation du scanner pour la saisie du nombre binaire
            System.out.print("Entrez un nombre binaire: "); //Message pour l'utilisateur
            String binaryNumber = inputBinary.nextLine(); //Sauvegarde de l'entrée utilisateur dans une String

            List<Integer> binaryNumberArray = new ArrayList<>(); //Initialisation d'une List<Integer> : cela signifie que cette liste va recevoir des nombres entiers

            for(int i = 0; i < binaryNumber.length(); i++) { //Pour chaque position dans la String binaryNumber
                binaryNumberArray.add(Integer.parseInt(binaryNumber.substring(i, i + 1))); //Convertir une String en Integer et ajoutez à la liste
            }

            int result = binaryNumberArray.getFirst(); //1er position de la liste

            for(int i = 1; i < binaryNumberArray.size(); i++) { //Pour chaque position dans la liste
                result = result * 2 + binaryNumberArray.get(i); //Result = Result * 2 + le chiffre de la meme position (For commence a 1)
            }
            System.out.println("Le nombre decimal est: " + result);
    }
}
