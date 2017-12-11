package com.coderbd.domain;

/**
 *
 * @author Mohammad Rajaul Islam
 * @url coderbd.com
 * @since 1.0.1
 */
public class Person {

    private int id;
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
