package com.kha.relationship.controller.impl;

import com.kha.relationship.controller.IBookController;
import com.kha.relationship.dto.DtoBook;
import com.kha.relationship.dto.DtoBookUI;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
public class BookControllerImpl implements IBookController {
    @Override
    public DtoBook createBook(DtoBookUI dtoBookUI) {
        return null;
    }

    @Override
    public DtoBook getBookById(int id) {
        return null;
    }

    @Override
    public boolean deleteBookById(int id) {
        return false;
    }
}
