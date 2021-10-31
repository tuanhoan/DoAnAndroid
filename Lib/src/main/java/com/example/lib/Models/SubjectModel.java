package com.example.lib.Models;

import java.io.Serializable;

public class SubjectModel implements Serializable {
    public int id;
    public String name;

    public SubjectModel() {
    }

    public SubjectModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SubjectModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
