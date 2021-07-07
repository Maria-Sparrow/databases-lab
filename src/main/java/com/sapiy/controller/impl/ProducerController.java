package com.sapiy.controller.impl;

import com.sapiy.controller.GeneralController;
import com.sapiy.model.DAO.implement.ProducerDaoImpl;
import com.sapiy.model.entity.Producer;

import java.sql.SQLException;
import java.util.List;

public class ProducerController implements GeneralController<Producer> {
  private static final ProducerDaoImpl producer = new ProducerDaoImpl();

  public ProducerController() {

  }

  @Override
  public List<Producer> findAll() {
    return producer.findAll();
  }

  @Override
  public Producer findOne(Integer id) throws SQLException {
    return producer.findOne(id);
  }

  @Override
  public void create(Producer object) throws SQLException {
    producer.create(object);
  }

  @Override
  public void update(Integer id, Producer object) {
    producer.update(id, object);
  }

  @Override
  public void delete(Integer id) {
    producer.delete(id);
  }
}
