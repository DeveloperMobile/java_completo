package exercice.application;

import exercice.entities.Client;
import exercice.entities.Order;
import exercice.entities.OrderItem;
import exercice.entities.Product;
import exercice.entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter cliente data: ");
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), status, client);

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter #" + (i + 1) + " item data: ");
            System.out.print("Product name: ");
            sc.nextLine();
            String pName = sc.nextLine();
            System.out.print("Product price: ");
            double pPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            order.addItem(new OrderItem(quantity, pPrice, new Product(pName, pPrice)));
        }

        System.out.println("ORDER SUMMARY: ");
        System.out.println(order);


        sc.close();
    }
}
