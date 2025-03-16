package com.kha.relationship.service.impl;

import com.kha.relationship.dto.DtoAuthor;
import com.kha.relationship.dto.DtoAuthorUI;
import com.kha.relationship.dto.DtoBook;
import com.kha.relationship.entity.Author;
import com.kha.relationship.entity.Book;
import com.kha.relationship.repository.AuthorRepository;
import com.kha.relationship.service.IAuthorService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements IAuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public DtoAuthor createAuthor(DtoAuthorUI dtoAuthorUI) {
        Author author = new Author();
        BeanUtils.copyProperties(dtoAuthorUI, author);
        author.setBook(new ArrayList<>());
        return fromAuthorToDtoAuthor(authorRepository.save(author));
    }

    @Override
    public boolean deleteAuthorById(int id) {
        return false;
    }

    @Override
    public Author findAuthorById(int id) {
        Optional<Author> optional = authorRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public DtoAuthor getAuthorById(int id) {
        Author author = findAuthorById(id);
        return fromAuthorToDtoAuthor(author);
    }

    @Override
    public DtoAuthor fromAuthorToDtoAuthor(Author author) {
        if (author != null){
            DtoAuthor dtoAuthor = new DtoAuthor();
            BeanUtils.copyProperties(author, dtoAuthor);
            for (Book book : author.getBook()){
                DtoBook dtoBook = new DtoBook();
                BeanUtils.copyProperties(book, dtoBook);
                dtoAuthor.getDtoBooks().add(dtoBook);
            }
            return dtoAuthor;
        }else {
            return null;
        }
    }

}
