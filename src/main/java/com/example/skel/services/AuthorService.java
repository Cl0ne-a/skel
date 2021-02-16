package com.example.skel.services;
import com.example.skel.domain.Author;
import javax.annotation.Resource;
import java.util.List;


public interface AuthorService {
    Author findAuthorById(int id);
    List<Author> findAll();


}
