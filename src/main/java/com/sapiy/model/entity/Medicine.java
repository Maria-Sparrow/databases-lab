package com.sapiy.model.entity;

public class Medicine {
    public int id;
    public String name;
    public String price ;
    private int medicine_storage_id;
    private int medicine_categories_id;
    private int using_in_life_id;


    public Medicine(int id, String name,String price, int medicine_storage_id,int medicine_categories_id, int using_in_life_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.medicine_storage_id = medicine_storage_id;
        this.medicine_categories_id = medicine_categories_id;
        this.using_in_life_id = using_in_life_id;
    }
    public Medicine(String name,String price, int medicine_storage_id,int medicine_categories_id, int using_in_life_id) {
        this.name = name;
        this.price = price;
        this.medicine_storage_id = medicine_storage_id;
        this.medicine_categories_id = medicine_categories_id;
        this.using_in_life_id = using_in_life_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMedicine_storage_id() {
        return medicine_storage_id;
    }

    public void setMedicine_storage_id(int medicine_storage_id) {
        this.medicine_storage_id = medicine_storage_id;
    }

    public int getMedicine_categories_id() {
        return medicine_categories_id;
    }

    public void setMedicine_categories_id(int medicine_categories_id) {
        this.medicine_categories_id = medicine_categories_id;
    }

    public int getUsing_in_life_id() {
        return using_in_life_id;
    }

    public void setUsing_in_life_id(int using_in_life_id) {
        this.using_in_life_id = using_in_life_id;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", medicine_storage_id=" + medicine_storage_id +
                ", medicine_categories_id=" + medicine_categories_id +
                ", using_in_life_id=" + using_in_life_id +
                '}';
    }
}
