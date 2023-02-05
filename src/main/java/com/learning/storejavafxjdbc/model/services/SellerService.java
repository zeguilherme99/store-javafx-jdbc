package com.learning.storejavafxjdbc.model.services;

import com.learning.storejavafxjdbc.model.dao.DaoFactory;
import com.learning.storejavafxjdbc.model.dao.SellerDao;
import com.learning.storejavafxjdbc.model.entities.Seller;

import java.util.List;

public class SellerService {

    private SellerDao dao = DaoFactory.createSellerDao();

    public List<Seller> findAll() {
        return dao.findAll();
    }

    public void saveOrUpdate(Seller obj) {
        if (obj.getId() == null) {
            dao.insert(obj);
        } else {
            dao.update(obj);
        }
    }

    public void remove(Seller obj) {
        dao.deleteById(obj.getId());
    }
}
