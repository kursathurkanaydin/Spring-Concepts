package com.kha.relationship.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Table(name = "book")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "year-MM-dd")
    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @ManyToOne
    private Author author;


}
