package com.sapiy.controller.impl;

import com.sapiy.controller.GeneralController;
import com.sapiy.model.DAO.implement.TypeOfPackingDaoImpl;
import com.sapiy.model.entity.TypeOfPacking;

import java.util.List;

public class TypeOfPackingController implements GeneralController<TypeOfPacking> {
    private static final TypeOfPackingDaoImpl typeOfPacking = new TypeOfPackingDaoImpl();

    public TypeOfPackingController() {

    }

    @Override
    public List<TypeOfPacking> findAll() {
        return typeOfPacking.findAll();
    }

    @Override
    public TypeOfPacking findOne(Integer id) {
        return typeOfPacking.findOne(id);
    }

    @Override
    public void create(TypeOfPacking object) {
        typeOfPacking.create(object);
    }

    @Override
    public void update(Integer id, TypeOfPacking object) {
        typeOfPacking.update(id, object);
    }

    @Override
    public void delete(Integer id) {
        typeOfPacking.delete(id);
    }
}
