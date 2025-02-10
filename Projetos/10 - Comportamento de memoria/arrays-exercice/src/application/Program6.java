package application;

import java.util.Locale;
import java.util.Scanner;

public class Program6 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n, pares;

        System.out.print("quantos numeros voce vai digitar? ");
        n = sc.nextInt();

        int[] vect = new int[n];
        pares = 0;

        for (int i = 0; i < vect.length; i++) {
            System.out.print("Digite um numero: ");
            vect[i] = sc.nextInt();
            if (vect[i] % 2 == 0) {
                pares++;
            }
        }

        System.out.println();
        System.out.println("NUMERO PARES: ");
        for (int i = 0; i < vect.length; i++) {
            if (vect[i] % 2 == 0) {
                System.out.print(vect[i] + " ");
            }
        }

        System.out.println();
        System.out.println();
        System.out.printf("QUANTIDADE DE PARES = %d", pares);
    }
}
