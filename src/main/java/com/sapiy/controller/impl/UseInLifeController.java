package com.sapiy.controller.impl;

import com.sapiy.controller.GeneralController;
import com.sapiy.model.DAO.implement.UsingInLifeDaoImpl;
import com.sapiy.model.entity.UsingInLife;

import java.util.List;

public class UseInLifeController implements GeneralController<UsingInLife> {
    private static final UsingInLifeDaoImpl useInLife = new UsingInLifeDaoImpl();
    

    public UseInLifeController() {

    }

    @Override
    public List<UsingInLife> findAll() {
        return useInLife.findAll();
    }

    @Override
    public UsingInLife findOne(Integer id) {
        return useInLife.findOne(id);
    }

    @Override
    public void create(UsingInLife object) {
        useInLife.create(object);
    }

    @Override
    public void update(Integer id, UsingInLife object) {
        useInLife.update(id, object);
    }

    @Override
    public void delete(Integer id) {
        useInLife.delete(id);
    }
}
