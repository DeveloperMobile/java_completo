package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program4 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();

        System.out.println();

        List<Employee> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + (i + 1));
            System.out.print("Id: ");
            int id = sc.nextInt();

            while (hasId(list, id)) {
                System.out.print("Id already taken. Try again: ");
                id = sc.nextInt();
            }

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            list.add(new Employee(id, name, salary));
            System.out.println();
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();

        Employee employee = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        if (employee != null) {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            employee.increaseSalary(percentage);
        } else {
            System.out.println("This id does not exist!");
        }

        System.out.println();

        System.out.println("List of employees: ");

        for (Employee e : list) {
            System.out.println(e);
        }

        sc.close();
    }

    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}
