package com.kha.relationship.service;

import com.kha.relationship.dto.DtoAuthor;
import com.kha.relationship.dto.DtoAuthorUI;
import com.kha.relationship.entity.Author;

public interface IAuthorService {
    DtoAuthor createAuthor(DtoAuthorUI dtoAuthorUI);
    boolean deleteAuthorById(int id);
    Author findAuthorById(int id);
    DtoAuthor getAuthorById(int id);
    DtoAuthor fromAuthorToDtoAuthor(Author author);

}
