package com.example.skel.services;

import com.example.skel.domain.Author;
import com.example.skel.domain.Books;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.awt.print.Book;
import java.util.Date;
import java.util.List;


public interface BooksService {

    List<Books> findAll();

    Books foundById(int id);

    List <Books> foundByAuthorAlive();

    boolean authorIsAlive();

}