package com.example.skel.services.impl;

import com.example.skel.domain.Books;
import com.example.skel.services.BooksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import java.awt.print.Book;
import java.util.*;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Log
@Service
public class BooksServiceImpl implements BooksService{
    Books foundBook = null;
    List<Books> library = new ArrayList<>();

    @Autowired
    AuthorServiceImpl authorService;



    @PostConstruct
    public void postConstructBooks(){
        log.info("BOOKS POSTCONSTRUCT");

        for (int i = 1, k = 1; i <= 25; i++) {
            Books book = Books.builder().id(i).name("Book"+i).author(authorService.findAuthorById(k)).build();
            this.library.add(book);
            if (i%5==0){k++;}
        }

    }


    @Override
    public List<Books> findAll() {
        return library;
    }



    @Override
    public Books foundById(int id) {
        for (Books book:
            library ) {
            if (book.getId()==id){
                foundBook = book;
            }
        }
        return foundBook;
    }


}
