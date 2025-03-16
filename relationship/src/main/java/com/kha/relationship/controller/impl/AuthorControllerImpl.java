package com.kha.relationship.controller.impl;

import com.kha.relationship.controller.IAuthorController;
import com.kha.relationship.dto.DtoAuthor;
import com.kha.relationship.dto.DtoAuthorUI;
import com.kha.relationship.service.impl.AuthorServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author")
public class AuthorControllerImpl implements IAuthorController {
    private final AuthorServiceImpl authorService;
    public AuthorControllerImpl(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @Override
    @PostMapping("/create")
    public DtoAuthor createAuthor(DtoAuthorUI dtoAuthorUI) {
        return authorService.createAuthor(dtoAuthorUI);
    }

    @Override
    @GetMapping("/get/{id}")
    public DtoAuthor getAuthorById(@PathVariable(name = "id") int id) {
        return authorService.getAuthorById(id);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public boolean deleteAuthorById(@PathVariable(name = "id") int id) {
        return false;
    }
}
