package com.kha.relationship.controller;

import com.kha.relationship.dto.DtoAuthor;
import com.kha.relationship.dto.DtoAuthorUI;
import com.kha.relationship.entity.Author;

public interface IAuthorController {
    DtoAuthor createAuthor(DtoAuthorUI dtoAuthorUI);
    DtoAuthor getAuthorById(int id);
    boolean deleteAuthorById(int id);
}
