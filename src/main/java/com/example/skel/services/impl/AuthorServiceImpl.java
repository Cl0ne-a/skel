package com.example.skel.services.impl;

import com.example.skel.domain.Author;
import com.example.skel.domain.Books;
import com.example.skel.services.AuthorService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Log
@Service
public class AuthorServiceImpl implements AuthorService {

    private final List <Author> authorList = new ArrayList<>();

    @PostConstruct
    public void postConstructAuthor(){

        log.info("AUTHOR POSTCONSTRUCT");
        this.authorList.add(Author.builder()
                .id(1).firstName("Auth1").lastName("Auth1")
                .birthday(new Date(1900, 5, 5)).deathday(new Date(2000, 8,1))
                .build());
        this.authorList.add(Author.builder()
                .id(2).firstName("Auth2").lastName("Auth2")
                .birthday(new Date(1900, 5, 5)).deathday(new Date(2000, 8,1))
                .build());
        this.authorList.add(Author.builder()
                .id(3).firstName("Auth3").lastName("Auth3")
                .birthday(new Date(1900, 5, 5)).deathday(new Date(2000, 8,1))
                .build());
        this.authorList.add(Author.builder()
                .id(4).firstName("Auth4").lastName("Auth4")
                .birthday(new Date(1900, 5, 5)).deathday(new Date(2000, 8,1))
                .build());
        this.authorList.add(Author.builder()
                .id(5).firstName("Auth5").lastName("Auth5")
                .birthday(new Date(0, 5, 5)).deathday(new Date(70, 8,1))
                .build());
                }


    @Override
    public Author findAuthorById(int id) {
        Author foundAuthor = null;
        for (Author author: authorList) {
            if (author.getId()==id){
                foundAuthor = author;
            }
        }
        return foundAuthor;
    }

    @Override
    public List<Author> findAll() {
        return authorList;
    }
}
