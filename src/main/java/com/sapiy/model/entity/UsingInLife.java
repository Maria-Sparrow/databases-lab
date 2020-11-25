package com.sapiy.model.entity;

public class UsingInLife {
    public int id;
    public String using_in;

    public UsingInLife(int id, String using_in) {
        this.id = id;
        this.using_in = using_in;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsing_in() {
        return using_in;
    }

    public void setUsing_in(String using_in) {
        this.using_in = using_in;
    }

    @Override
    public String toString() {
        return "UsingInLife{" +
                "id=" + id +
                ", using_in='" + using_in + '\'' +
                '}';
    }
}
