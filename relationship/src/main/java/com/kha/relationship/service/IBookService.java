package com.kha.relationship.service;

import com.kha.relationship.dto.DtoBook;
import com.kha.relationship.dto.DtoBookUI;
import com.kha.relationship.entity.Book;

public interface IBookService {
    DtoBook fromBookToDtoBook(Book book);
    Book findBookById(int id);
    DtoBook getBookById(int id);
    boolean deleteBookById(int id);
    Book createBook(DtoBookUI dtoBookUI);
    Book fromDtoBookUIToBook(DtoBookUI dtoBookUI);
}
