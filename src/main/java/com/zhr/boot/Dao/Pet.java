package com.zhr.boot.Dao;

public class Pet {
    public Pet(){}
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet(String name) {
        this.name = name;
    }
}
