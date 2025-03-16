package com.kha.relationship.service.impl;

import com.kha.relationship.dto.DtoBook;
import com.kha.relationship.dto.DtoBookUI;
import com.kha.relationship.entity.Book;
import com.kha.relationship.repository.BookRepository;
import com.kha.relationship.service.IBookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {
    private final BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public DtoBook fromBookToDtoBook(Book book) {
        return null;
    }

    @Override
    public Book findBookById(int id) {
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

    @Override
    public Book createBook(DtoBookUI dtoBookUI) {
        return null;
    }

    @Override
    public Book fromDtoBookUIToBook(DtoBookUI dtoBookUI) {
        Book book = new Book();
        return book;
    }
}
