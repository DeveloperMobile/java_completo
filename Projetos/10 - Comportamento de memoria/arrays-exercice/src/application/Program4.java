package application;

import entities.People;

import java.util.Locale;
import java.util.Scanner;

public class Program4 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas serao digitadas? ");
        int n = sc.nextInt();

        People[] vect = new People[n];

        double altAvg = 0.0;
        double sumAlt = 0.0;
        double sumAge = 0.0;

        for (int i = 1; i <= vect.length; i++) {
            System.out.println("Dados da " + i + "a pessoa: ");
            sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Idade: ");
            int idade = sc.nextInt();
            System.out.print("Altura: ");
            double altura = sc.nextDouble();
            vect[i - 1] = new People(nome, idade, altura);
            sumAlt += altura;
            if (idade < 16) {
                sumAge++;
            }
        }

        altAvg = sumAlt / vect.length;

        System.out.println();

        System.out.printf("Altura media: %.2f%n", altAvg);
        System.out.printf("Percentual de pessoas com menos de 16 anos: %.1f%s%n", sumAge / vect.length * 100, "%");

        for (int i = 0; i < vect.length; i++) {
            if (vect[i].getIdade() < 16) {
                System.out.println(vect[i].getNome());
            }
        }

        sc.close();
    }
}
