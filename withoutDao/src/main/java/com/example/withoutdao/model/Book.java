package com.example.withoutdao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int accessionNumber;
    private String author;
    private String title;
    private double price;

    public int getAccessionNumber() {
        return accessionNumber;
    }
    public void setAccessionNumber(int accessionNumber) {
        this.accessionNumber = accessionNumber;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

}
