package br.developermobile.application;

import br.developermobile.model.dao.DaoFactory;
import br.developermobile.model.dao.SellerDao;
import br.developermobile.model.entities.Seller;

public class Main {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
    }
}