package br.developermobile.model.dao;

import br.developermobile.db.DB;
import br.developermobile.model.dao.impl.DepartmentDaoJDBC;
import br.developermobile.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
