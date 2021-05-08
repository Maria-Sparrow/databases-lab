package com.sapiy.labs.service;
import java.util.List;

public interface MedService<E, ID> {

  public List<E> getAll();

  public E getById(ID id);

  public E create(E newObject);

  public E update(ID id, E object);

  public void deleteById(ID id);

}
