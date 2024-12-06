package org.example.springboot_usingdao.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;

public class Librarian {
    private int id;
    private String name;

    @JsonProperty("email")
    private String email;


    @JsonProperty("age")
    private int age;


    public Librarian(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
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
        this.name = this.name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
