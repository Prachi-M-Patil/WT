package org.example.springboot_usingdao.model;

import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class Library {
    private int id;
    private int prn;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrn() {
        return prn;
    }

    public void setPrn(int prn) {
        this.prn = prn;
    }
}
