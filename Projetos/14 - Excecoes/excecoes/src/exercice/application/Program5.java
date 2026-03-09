package exercice.application;

import exercice.domain.entities.Account;
import exercice.domain.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program5 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter account data ");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            double balance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account acc = new Account(number, holder, balance, withdrawLimit);

            System.out.println();
            System.out.print("Enter amount for wirthdraw: ");
            double amount = sc.nextDouble();

            acc.withdraw(amount);
            System.out.printf("New balance: %.2f%n", acc.getBalance());

        } catch (DomainException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }
    }
}
