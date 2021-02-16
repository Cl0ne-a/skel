package com.example.skel.services.impl;
import com.example.skel.domain.Books;
import com.example.skel.services.BooksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Log
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BooksServiceImpl implements BooksService{
    Books foundBook = null;
    List<Books> library = new ArrayList<>();

    @Autowired
    AuthorServiceImpl authorService;

    @PostConstruct
    public void postConstructBooks(){
        log.info("BOOKS POSTCONSTRUCT");

        for (int i = 1, k = 1; i <= 25; i++) {
            Books book = Books.builder().id(i).name("Book"+i).author(authorService.findAuthorById(k)).publicationDate(new Date(2000,05,05)).build();
            this.library.add(book);
            if (i%5==0){k++;}
        }
    }

    @Override
    public List<Books> foundByAuthorAlive() {
        return this.library.stream().filter(books -> books.getAuthor().getDeathday() == null).collect(Collectors.toList());
    }

    @Override
    public List<Books> findAll() {
        return library;
    }

    @Override
    public Books foundById(int id) {
        return this.library.stream().filter(books -> books.getId()==id).findFirst().orElse(null);
    }

    @Override
    public boolean authorIsAlive() {
        boolean authorAlive = false;
        for (Books book:
             library) {
            if (book.getAuthor().getDeathday()==null){
                authorAlive = true;
            }
        }
        return authorAlive;
    }
}
