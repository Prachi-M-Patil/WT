package com.example.withoutdao.model;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    private int prn;
    private String name;
    private int age;

    public int getPrn() {
            return prn;
    }
    public void setPrn(int prn) {
        this.prn = prn;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
