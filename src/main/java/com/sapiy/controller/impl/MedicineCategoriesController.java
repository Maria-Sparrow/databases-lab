package com.sapiy.controller.impl;

import com.sapiy.controller.GeneralController;
import com.sapiy.model.DAO.implement.MedicineCategoriesDaoImpl;
import com.sapiy.model.entity.MedicineCategories;

import java.sql.SQLException;
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
  public MedicineCategories findOne(Integer id) throws SQLException {
    return dao.findOne(id);
  }

  @Override
  public void create(MedicineCategories object) throws SQLException {
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
