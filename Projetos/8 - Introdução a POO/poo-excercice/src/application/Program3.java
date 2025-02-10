package application;

import entities.Student;

import java.util.Locale;
import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Student student = new Student();
        student.name = sc.nextLine();
        student.nota1 = sc.nextDouble();
        student.nota2 = sc.nextDouble();
        student.nota3 = sc.nextDouble();

        System.out.println();
        System.out.printf("FINAL GRADE = %.2f%n", student.finalGrade());
        student.status();

        sc.close();
    }
}
