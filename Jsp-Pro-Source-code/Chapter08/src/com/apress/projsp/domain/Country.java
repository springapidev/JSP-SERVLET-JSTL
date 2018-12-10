package com.apress.projsp.domain;

public class Country {

  private int id;
  private String name;

  public Country() {
  }

  public Country(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int i) {
    this.id = i;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String s) {
    this.name = s;
  }

}
