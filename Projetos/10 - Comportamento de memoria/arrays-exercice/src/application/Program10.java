package application;

import java.util.Locale;
import java.util.Scanner;

public class Program10 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos elementos vai ter o vetor? ");
        int n = sc.nextInt();

        double[] vect = new double[n];

        int pares = 0;
        double media = 0.0;
        double soma = 0.0;

        for (int i = 0; i < vect.length; i++) {
            System.out.print("Digite um numero: ");
            vect[i] = sc.nextDouble();
            if (vect[i] % 2 == 0) {
                pares++;
                soma += vect[i];
            }
        }

        if (pares > 0) {
            media = soma / pares;

            System.out.println();
            System.out.printf("MEDIA DOS PARES = %.1f\n", media);
        } else {
            System.out.println("NENHUM NUMERO PAR");
        }

        sc.close();
    }
}
