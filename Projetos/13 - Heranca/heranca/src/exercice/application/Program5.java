package exercice.application;

import exercice.entities.ImportedProduct;
import exercice.entities.Product;
import exercice.entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program5 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Product #" + (i + 1) + " data: ");
            System.out.print("Common, userd or imported (c/u/i)? ");
            sc.nextLine();
            char ch = sc.nextLine().charAt(0);
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            if (ch == 'i') {
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                Product product = new ImportedProduct(name, price, customsFee);
                products.add(product);
            } else if (ch == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                sc.nextLine();
                String date = sc.nextLine();
                Date manufacturedDate = sdf.parse(date);
                Product product = new UsedProduct(name, price, manufacturedDate);
                products.add(product);
            } else {
                Product product = new Product(name, price);
                products.add(product);
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS: ");

        for (Product product : products) {
            System.out.println(product.priceTag());
        }

        sc.close();
    }
}
