package application;

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Program13 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas serao digitadas? ");
        int n = sc.nextInt();

        double[] alturas = new double[n];
        String[] generos = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Altura da %da pessoa: ", i + 1);
            alturas[i] = sc.nextDouble();
            System.out.printf("Genero da %da pessoa: ", i + 1);
            sc.nextLine();
            generos[i] = sc.nextLine();
        }

        double maior = alturas[0];
        double menor = alturas[0];
        double soma = 0.0;
        int nAlturas = 0;
        int homens = 0;

        for (int i = 0; i < alturas.length; i++) {
            if (alturas[i] > maior) {
                maior = alturas[i];
            }

            if (alturas[i] < menor) {
                menor = alturas[i];
            }
        }

        for (int i = 0; i < generos.length; i++) {
            if (generos[i].equals("F")) {
                soma += alturas[i];
                nAlturas++;
            } else {
                homens++;
            }
        }

        double media  = soma / nAlturas;

        System.out.printf("Menor altura = %.2f\n", menor);
        System.out.printf("Maior altura = %.2f\n", maior);
        System.out.printf("Media das alturas das mulheres = %.2f\n", media);
        System.out.printf("Numero de homens = %d", homens);

        sc.close();
    }
}
