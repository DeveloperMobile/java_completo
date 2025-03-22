package br.developermobile.application;

import br.developermobile.model.dao.DaoFactory;
import br.developermobile.model.dao.SellerDao;
import br.developermobile.model.entities.Department;
import br.developermobile.model.entities.Seller;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        list.forEach(System.out::println);

        System.out.println("\n=== TEST 3: seller findAll ====");
        list = sellerDao.findAll();
        list.forEach(System.out::println);
    }
}