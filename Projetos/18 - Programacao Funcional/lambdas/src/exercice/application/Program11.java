package exercice.application;

import exercice.entities.Employee;
import exercice.entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program11 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = sc.nextLine();

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Employee> list = new ArrayList<>();
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            System.out.printf("Email of people whose salary is more than: %.2f%n", salary);

            Comparator<String> comp = Comparator.comparing(String::toUpperCase);

            List<String> emails = list.stream()
                    .filter(e -> e.getSalary() > salary)
                    .map(Employee::getEmail)
                    .sorted(comp)
                    .toList();

            emails.forEach(System.out::println);

            double sumSalary = list.stream()
                    .filter(e -> e.getName().charAt(0) == 'M')
                    .map(Employee::getSalary)
                    .reduce(0.0, Double::sum);

            System.out.printf("Sum of salary of pelople whose name starts with 'M': %.2f", sumSalary);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
