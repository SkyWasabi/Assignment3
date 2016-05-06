package com.example.dakeh.assignment3;

/**
 * Created by dakeh on 5/2/2016.
 */
public class Collection {
    int id;
    String n;

    public Collection() {

    }

    public Collection(String name) {
        this.n = name;
    }

    public Collection(int id, String name) {
        this.id = id;
        this.n = name;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void setName(String name) {
        this.n = name;
    }

    public String getName() {
        return n;
    }
}