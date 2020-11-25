package com.sapiy.controller.impl;

import com.sapiy.controller.GeneralController;
import com.sapiy.model.DAO.implement.MedicineStorageDaoImpl;
import com.sapiy.model.DAO.implement.ProducerDaoImpl;
import com.sapiy.model.entity.MedicineStorage;
import com.sapiy.model.entity.Producer;

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
    public Producer findOne(Integer id) {
        return producer.findOne(id);
    }

    @Override
    public void create(Producer object) {
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
