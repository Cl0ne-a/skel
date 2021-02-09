package com.example.skel.services;

import com.example.skel.domain.Author;
import com.example.skel.domain.Books;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import javax.annotation.Nullable;
import java.awt.print.Book;
import java.util.Date;
import java.util.List;

@RestResource(path = "/api/booksList")
public interface BooksService {

    List<Books> findAll();

    Books foundById(int id);

}