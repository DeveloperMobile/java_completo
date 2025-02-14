package application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Account account;

        System.out.print("Enter account number: ");
        int number = sc.nextInt();

        System.out.println();

        System.out.print("Enter account holder: ");
        sc.nextLine();
        String holder = sc.nextLine();

        System.out.println();

        System.out.print("Is here na initial deposit (y/n)? ");
        char resp = sc.next().charAt(0);

        System.out.println();

        if (resp == 'y') {
            System.out.print("Enter initial deposit: ");
            double initialDeposit = sc.nextDouble();
            account = new Account(number, holder, initialDeposit);
        } else {
            account = new Account(number, holder);
        }

        System.out.println(account);

        System.out.println();

        System.out.print("Enter deposit value: ");
        double amount = sc.nextDouble();
        account.deposit(amount);

        System.out.println();

        System.out.println("Update acount data: ");
        System.out.println(account);

        System.out.println();

        System.out.print("Enter withdraw value: ");
        amount = sc.nextDouble();
        account.withdraw(amount);

        System.out.println();

        System.out.println("Update acount data: ");
        System.out.print(account);

        sc.close();
    }
}
