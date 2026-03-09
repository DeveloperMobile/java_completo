package proj2.application;



import proj1.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class Program3 {
    public static int compareProducts(Product p1, Product p2) {
        return p1.getPrice().compareTo(p2.getPrice());
    }

    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.0));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));

        list.sort(Program3::compareProducts);

        list.forEach(System.out::println);
    }
}
