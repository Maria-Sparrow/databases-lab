package com.sapiy.model.entity;

public class Producer {
    public int id;
    public String name_producer;

    public Producer(int id, String name_producer) {
        this.id = id;
        this.name_producer = name_producer;
    }
    public Producer(String name_producer) {
        this.name_producer = name_producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_producer() {
        return name_producer;
    }

    public void setName_producer(String name_producer) {
        this.name_producer = name_producer;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", name_producer='" + name_producer + '\'' +
                '}';
    }
}
