package com.sapiy.model.DAO;

import com.sapiy.model.entity.MedicineCategories;

import java.sql.SQLException;
import java.util.List;

public interface MedicineCategoriesDao {
  List<MedicineCategories> findAll() throws SQLException;

  MedicineCategories findOne(Integer id) throws SQLException;

  void create(MedicineCategories object) throws SQLException;

  void update(Integer id, MedicineCategories object) throws SQLException;

  void delete(Integer id) throws SQLException;


}
