package com.sapiy.model.entity;

public class MedicineCategories {
    public int id;
    public String categories ;

    public MedicineCategories(int id, String categories) {
        this.id = id;
        this.categories = categories;
    }
    public MedicineCategories(String categories) {
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "MedicineCategories{" +
                "id=" + id +
                ", categories='" + categories + '\'' +
                '}';
    }
}
