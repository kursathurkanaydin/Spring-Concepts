package com.kha.relationship.controller;

import com.kha.relationship.dto.DtoAuthor;
import com.kha.relationship.dto.DtoAuthorUI;
import com.kha.relationship.dto.DtoBook;
import com.kha.relationship.dto.DtoBookUI;

public interface IBookController {
    DtoBook createBook(DtoBookUI dtoBookUI);
    DtoBook getBookById(int id);
    boolean deleteBookById(int id);
}
