package exercice.application;

import exercice.entities.Company;
import exercice.entities.Individual;
import exercice.entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program8 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Tax payer #" + (i + 1) + " data: ");
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: " );
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double income = sc.nextDouble();

            if (ch == 'i') {
                System.out.print("Health expenditures: ");
                double healtExpenditures = sc.nextDouble();
                list.add(new Individual(name, income, healtExpenditures));
            } else {
                System.out.print("Number of employess: ");
                int numberOfEmployees = sc.nextInt();
                list.add(new Company(name, income, numberOfEmployees));
            }
        }

        double totalTax = 0.0;
        System.out.println();
        System.out.println("TAXEX PAID: ");

        for (TaxPayer t : list) {
            System.out.println(t.getName() + ": $ " + String.format("%.2f", t.tax()));
            totalTax += t.tax();
        }

        System.out.println();
        System.out.printf("TOTAL TAXES: $%.2f", totalTax);

        sc.close();
    }
}
