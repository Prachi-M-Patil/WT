package org.example.springboot_usingdao.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter

@Entity(name = "lms_Book")
public class Book {

    @Id
    @JsonProperty("ass_no")
    private int assNo;

    @Column(nullable = false)
    @JsonProperty("title")
    private String title;

    @Column(nullable = false)
    @JsonProperty("author")
    private String author;

    @Column(nullable = false)
    @JsonProperty("price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "prn")

    private Student student;

    // Constructor





}
