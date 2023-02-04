package com.learning.storejavafxjdbc.model.services;

import com.learning.storejavafxjdbc.model.dao.DaoFactory;
import com.learning.storejavafxjdbc.model.dao.DepartmentDao;
import com.learning.storejavafxjdbc.model.entities.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    private DepartmentDao dao = DaoFactory.createDepartmentDao();

    public List<Department> findAll() {
        return dao.findAll();
    }
}
