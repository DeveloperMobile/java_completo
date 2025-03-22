package br.developermobile.application;

import br.developermobile.model.dao.DaoFactory;
import br.developermobile.model.dao.DepartmentDao;
import br.developermobile.model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: findById =======");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println("=== TEST 2: findById =======");
        List<Department> list = departmentDao.findAll();
        list.forEach(System.out::println);

        System.out.println("=== TEST 3: insert =======");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());

        System.out.println("=== TEST 4: update =======");
        Department department = departmentDao.findById(1);
        department.setName("Food");
        departmentDao.update(department);
        System.out.println("Update completed!");

        System.out.println("=== TEST 5: delete =======");
        System.out.print("Enter id for delete text: ");
        int id = sc.nextInt();
        departmentDao.delete(id);
        System.out.println("Delete completed");

        sc.close();
    }
}
