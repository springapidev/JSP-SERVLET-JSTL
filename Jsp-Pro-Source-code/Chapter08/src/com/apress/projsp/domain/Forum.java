package com.apress.projsp.domain;

public class Forum {
  private int id;
  private String name;

  public Forum() {
  }

  public Forum(int i, String s) {
    id = i;
    name = s;
  }

  public int getId() {
    return id;
  }

  public void setId(int i) {
    id = i;
  }

  public String getName() {
    return name;
  }

  public void setName(String s) {
    name = s;
  }
}