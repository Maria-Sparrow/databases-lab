package com.sapiy.controller.impl;

import com.sapiy.controller.GeneralController;
import com.sapiy.model.DAO.implement.MedicineStorageDaoImpl;

import com.sapiy.model.entity.MedicineStorage;

import java.util.List;

public class MedicineStorageController implements GeneralController<MedicineStorage> {
    private final static MedicineStorageDaoImpl medicineStorage = new MedicineStorageDaoImpl();


    public MedicineStorageController() {

    }

    @Override
    public List<MedicineStorage> findAll() {
        return medicineStorage.findAll();
    }

    @Override
    public MedicineStorage findOne(Integer id) {
        return medicineStorage.findOne(id);
    }

    @Override
    public void create(MedicineStorage object) {
        medicineStorage.create(object);
    }

    @Override
    public void update(Integer id, MedicineStorage object) {
        medicineStorage.update(id, object);
    }

    @Override
    public void delete(Integer id) {
        medicineStorage.delete(id);
    }
}
