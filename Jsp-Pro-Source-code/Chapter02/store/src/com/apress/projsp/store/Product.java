package com.apress.projsp.store;

public class Product {

  private String name;
  private String price;
  private int id;

  public Product(int id, String name, String price) {
    this.price = price;
    this.name = name;
    this.id=id;
  }

  public String getPrice() {
     return this.price;
  }

  public String getName() {
    return this.name;
  }

  public int getId() {
    return this.id;
  }

  public String toString() {
	  return "Product:id=" + id + " name=" + name + " price="+price;
  }

}