package com.sapiy.model.DAO;

import com.sapiy.model.entity.MedicineStorage;

import java.sql.SQLException;
import java.util.List;

public interface MedicineStorageDao {
    List<MedicineStorage> findAll() throws SQLException;

    MedicineStorage findOne(Integer id) throws SQLException;

    void create(MedicineStorage object) throws SQLException;

    void update(Integer id, MedicineStorage object) throws SQLException;

    void delete(Integer id) throws SQLException;

}
