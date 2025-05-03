package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        BigInteger valeur = BigInteger.ONE;
        int valeurMax = 100;
        List<BigInteger> fibonnaci = new ArrayList<>();

        for (int i = 0; i < valeurMax; i++) {
            if (i < 2) {
                fibonnaci.add(valeur);
            } else if (fibonnaci.size() < valeurMax) {
                BigInteger nextValue = fibonnaci.get(i - 2).add(fibonnaci.get(i - 1));
                fibonnaci.add(nextValue);
            }
        }
            System.out.println(fibonnaci);
    }
}