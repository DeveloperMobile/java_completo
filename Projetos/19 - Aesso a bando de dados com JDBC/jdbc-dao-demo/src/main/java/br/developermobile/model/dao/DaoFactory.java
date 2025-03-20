package br.developermobile.model.dao;

import br.developermobile.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC();
    }
}
