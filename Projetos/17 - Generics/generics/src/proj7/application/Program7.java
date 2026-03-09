package proj7.application;

import proj7.entities.Product;

import java.util.HashSet;
import java.util.Set;

public class Program7 {
    public static void main(String[] args) {
        Set<Product> set = new HashSet<>();

        set.add(new Product("TV", 900.0));
        set.add(new Product("Notebook", 1200.00));
        set.add(new Product("Tablet", 400.0));

        Product prod = new Product("Notebbok", 1200.00);

        System.out.println(set.contains(prod));
    }
}
