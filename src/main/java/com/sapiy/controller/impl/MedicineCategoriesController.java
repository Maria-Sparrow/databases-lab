package com.sapiy.controller.impl;

import com.sapiy.controller.GeneralController;
import com.sapiy.model.DAO.implement.MedicineCategoriesDaoImpl;
import com.sapiy.model.entity.MedicineCategories;

import java.util.List;

public class MedicineCategoriesController implements GeneralController<MedicineCategories> {
    private static final MedicineCategoriesDaoImpl dao = new MedicineCategoriesDaoImpl();

    public MedicineCategoriesController() {

    }

    @Override
    public List<MedicineCategories> findAll() {
        return dao.findAll();
    }

    @Override
    public MedicineCategories findOne(Integer id) {
        return dao.findOne(id);
    }

    @Override
    public void create(MedicineCategories object) {
        dao.create(object);
    }

    @Override
    public void update(Integer id, MedicineCategories object) {
        dao.update(id, object);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }

}
