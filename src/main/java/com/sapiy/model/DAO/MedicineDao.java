package com.sapiy.model.DAO;

import com.sapiy.model.entity.Medicine;

import java.sql.SQLException;
import java.util.List;

public interface MedicineDao {
    List<Medicine> findAll() throws SQLException;

    Medicine findOne(Integer id) throws SQLException;

    void create(Medicine object) throws SQLException;

    void update(Integer id, Medicine object) throws SQLException;

    void delete(Integer id) throws SQLException;


}
