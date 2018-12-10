/*
 * Simple object that represents a Book
 */
package com.apress.projsp;

import java.util.*;

public class Book {

    private String title;
    private String author;
    private String isbn;
    private double price;
    private String url;
    TimeZone zone;

    public static void main(String[] args) {
      String[] ids = TimeZone.getAvailableIDs();
        for (int i = 0; i < ids.length; i++) {
            System.out.println(ids[i]);
        }
    }

    public Book() {
    }

    public Book(String title) {
        setTitle(title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public double getPrice() {
        return this.price;
    }

    public String getUrl() {
        Calendar cal = new GregorianCalendar();
        cal.get(Calendar.HOUR_OF_DAY);

        return this.url;
    }
}
