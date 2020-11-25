package com.sapiy.model.DAO;

import com.sapiy.model.entity.UsingInLife;

import java.sql.SQLException;
import java.util.List;

public interface UsingInLifeDao {
    List<UsingInLife> findAll() throws SQLException;

    UsingInLife findOne(Integer id) throws SQLException;

    void create(UsingInLife object) throws SQLException;

    void update(Integer id, UsingInLife object) throws SQLException;

    void delete(Integer id) throws SQLException;
}
