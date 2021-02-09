package com.example.skel.services;

import com.example.skel.domain.Author;
import org.springframework.data.rest.core.annotation.RestResource;


import java.util.List;

@RestResource(path = "/api/authorList")
public interface AuthorService {
    Author findAuthorById(int id);
    List<Author> findAll();


}
