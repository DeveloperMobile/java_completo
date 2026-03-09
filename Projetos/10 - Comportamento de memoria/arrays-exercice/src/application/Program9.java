package application;

import java.util.Locale;
import java.util.Scanner;

public class Program9 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos elementos vei ter o vetor? ");
        int n = sc.nextInt();
        double media = 0.0;
        double sum = 0.0;

        double[] vect = new double[n];

        for (int i = 0; i < vect.length; i++) {
            System.out.print("Digite um numero: ");
            vect[i] = sc.nextDouble();
            sum += vect[i];
        }

        System.out.println();

        media = sum / vect.length;
        System.out.printf("MEDIA DO VETOR = %.3f\n", media);

        System.out.println("ELEMENTOS ABAIXO DA MEDIA: ");

        for (int i = 0; i < vect.length; i++) {
            if (vect[i] < media) {
                System.out.println(vect[i]);
            }
        }

        sc.close();
    }
}
