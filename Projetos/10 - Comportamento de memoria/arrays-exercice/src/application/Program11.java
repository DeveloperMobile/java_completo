package application;

import java.util.Scanner;

public class Program11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas voce vai digirar? ");
        int n = sc.nextInt();

        String[] nomes = new String[n];
        int[] idades = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Dados da %da pessoa: \n", i + 1);
            System.out.print("Nome: ");
            nomes[i] = sc.next();
            System.out.print("Idade: ");
            idades[i] = sc.nextInt();
        }

        int maior = idades[0];
        int posmaior = 0;

        for (int i = 0; i < n; i++) {
            if (idades[i] > maior) {
                maior = idades[i];
                posmaior = i;
            }
        }

        System.out.println("PESSOA MAIS VELHA: " + nomes[posmaior]);

        sc.close();
    }
}
