package com.sapiy.model.entity;

public class MedicineStorage {
    public int id ;
    public String storage;

    public MedicineStorage(int id,String storage) {
        this.id = id;
        this.storage = storage;
    }
    public MedicineStorage(String storage) {
        this.storage = storage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "MedicineStorage{" +
                "id=" + id +
                ", storage='" + storage + '\'' +
                '}';
    }
}
