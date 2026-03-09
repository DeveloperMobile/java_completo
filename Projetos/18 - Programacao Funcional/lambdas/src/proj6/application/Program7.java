package proj6.application;

import proj6.model.entities.Product;
import proj6.model.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Program7 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 89.90));

        double sum = new ProductService().filteredSum(list, p -> p.getName().charAt(0) == 'T');
        System.out.println("Sum = " + String.format("%.2f", sum));
    }
}
