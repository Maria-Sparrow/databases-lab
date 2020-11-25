package com.sapiy.controller.impl;

import com.sapiy.controller.GeneralController;
import com.sapiy.model.DAO.implement.MedicineDaoImpl;
import com.sapiy.model.entity.Medicine;

import java.util.List;

public class MedicineController implements GeneralController<Medicine> {
    private static final MedicineDaoImpl medicine = new MedicineDaoImpl();
    
    public MedicineController() {

    }

    @Override
    public List<Medicine> findAll() {
        return medicine.findAll();
    }

    @Override
    public Medicine findOne(Integer id) {
        return medicine.findOne(id);
    }

    @Override
    public void create(Medicine object) {
        medicine.create(object);
    }

    @Override
    public void update(Integer id, Medicine object) {
        medicine.update(id, object);
    }

    @Override
    public void delete(Integer id) {
        medicine.delete(id);
    }
}
