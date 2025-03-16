package com.kha.relationship.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DtoBook {
    private int id;
    private String name;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "year-MM-dd")
    private LocalDate publicationDate;
    private DtoAuthor author;
}
