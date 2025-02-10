package application;

import entities.Student;

import java.util.Locale;
import java.util.Scanner;

public class Program12 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos alunos serao digitados? ");
        int n = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0 ; i < students.length; i++) {
            System.out.printf("Digite o nome, primeira e segunda nota do %do aluno: \n", i + 1);
            sc.nextLine();
            String nome = sc.nextLine();
            double nota1 = sc.nextDouble();
            double nota2 = sc.nextDouble();
            students[i] = new Student(nome, nota1, nota2);
        }

        System.out.println("Alunos aprovados: ");

        for (int i = 0; i < students.length; i++) {
            double media = (students[i].getNota1() + students[i].getNota2()) / 2;
            if (media >= 6) {
                System.out.println(students[i].getNome());
            }
        }

        sc.close();
    }
}
