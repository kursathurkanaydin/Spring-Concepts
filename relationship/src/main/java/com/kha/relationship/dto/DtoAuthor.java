package com.kha.relationship.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoAuthor {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private List<DtoBook> dtoBooks = new ArrayList<>();
}
