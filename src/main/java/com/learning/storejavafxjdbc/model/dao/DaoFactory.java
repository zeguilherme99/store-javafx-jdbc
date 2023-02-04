package com.learning.storejavafxjdbc.model.dao;

import com.learning.storejavafxjdbc.db.DB;
import com.learning.storejavafxjdbc.model.dao.impl.DepartmentDaoJDBC;
import com.learning.storejavafxjdbc.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
