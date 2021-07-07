package com.sapiy.model.DAO;

import com.sapiy.model.entity.TypeOfPacking;

import java.sql.SQLException;
import java.util.List;

public interface TypeOfPackingDao {
  List<TypeOfPacking> findAll() throws SQLException;

  TypeOfPacking findOne(Integer id) throws SQLException;

  void create(TypeOfPacking object) throws SQLException;

  void update(Integer id, TypeOfPacking object) throws SQLException;

  void delete(Integer id) throws SQLException;

}
