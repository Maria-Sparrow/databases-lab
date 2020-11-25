package com.sapiy.model.entity;

public class TypeOfPacking {
    public int id;
    public String type;

    public TypeOfPacking(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TypeOfPacking{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
