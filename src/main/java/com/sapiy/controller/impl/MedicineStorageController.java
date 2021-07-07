package com.sapiy.controller.impl;

import com.sapiy.controller.GeneralController;
import com.sapiy.model.DAO.implement.MedicineStorageDaoImpl;
import com.sapiy.model.entity.MedicineStorage;

import java.sql.SQLException;
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
  public MedicineStorage findOne(Integer id) throws SQLException {
    return medicineStorage.findOne(id);
  }

  @Override
  public void create(MedicineStorage object) throws SQLException {
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
