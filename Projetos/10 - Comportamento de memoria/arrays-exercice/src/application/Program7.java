package application;

import java.util.Locale;
import java.util.Scanner;

public class Program7 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n, posmaior;
        double maior = 0;

        System.out.print("quantos numeros voce vai digitar? ");
        n = sc.nextInt();

        double[] vect = new double[n];

        for (int i = 0; i < vect.length; i++) {
            System.out.print("Digite um numero: ");
            vect[i] = sc.nextDouble();
        }

        maior = vect[0];
        posmaior = 0;

        for (int i = 0; i < vect.length; i++) {
            if (vect[i] > maior) {
                maior = vect[i];
                posmaior = i;
            }
        }

        System.out.println();
        System.out.printf("MAIOR VALOR = %.1f\n", maior);
        System.out.printf("POSICAO DO MAIOR VALOR = %d", posmaior);

        sc.close();
    }
}
