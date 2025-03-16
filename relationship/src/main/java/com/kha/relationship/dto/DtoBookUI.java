package com.kha.relationship.dto;

import com.kha.relationship.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoBookUI {
    private String name;
    private LocalDate publicationDate;
    private int author_id;
}
