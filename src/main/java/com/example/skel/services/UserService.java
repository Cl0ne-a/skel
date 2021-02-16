package com.example.skel.services;
import com.example.skel.domain.Author;
import com.example.skel.domain.Books;
import com.example.skel.domain.User;
import javax.annotation.Resource;
import java.util.List;


public interface UserService {

    List <User>  findAll();
    User findById(int id);
    public List<String> distinctByNameWithBookList();
    List <String> findByAge(int minAge);
    int countBy();
    int userAge(int authorId);
    List<String>booksWithAuthorAlive();
}
