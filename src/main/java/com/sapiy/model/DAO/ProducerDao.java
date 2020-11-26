package com.sapiy.model.DAO;

import com.sapiy.model.entity.Producer;

import java.sql.SQLException;
import java.util.List;

public interface ProducerDao {
    List<Producer> findAll() throws SQLException;

    Producer findOne(Integer id) throws SQLException;

    void create(Producer object) throws SQLException;

    void update(Integer id, Producer object) throws SQLException;

    void delete(Integer id) throws SQLException;

}
