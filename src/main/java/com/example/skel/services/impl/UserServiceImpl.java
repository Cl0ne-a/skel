package com.example.skel.services.impl;

import com.example.skel.domain.Books;
import com.example.skel.domain.User;
import com.example.skel.services.UserService;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Log
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService{
    @Autowired
    BooksServiceImpl booksService;


    List<User>userList = new ArrayList<>();
    


    @PostConstruct
    public void postConstructUsers(){
        log.info("USER POSTCONSTRUCT");
        for (int i = 1; i <5 ; i++) {

        }
        List<Books>collection1 = new ArrayList<>();
        for (int i = 1; i<3; i++) {
            collection1.add(booksService.foundById(i));
        }
        List<Books>collection2 = new ArrayList<>();
        for (int i = 3; i < 10; i++) {
            collection2.add(booksService.foundById(i));
        }
        List<Books>collection3 = new ArrayList<>();
        for (int i = 10; i < 15; i++) {
            collection3.add(booksService.foundById(i));
        }
        List<Books>collection4 = new ArrayList<>();
        for (int i = 15; i < 20; i++) {
            collection4.add(booksService.foundById(i));
        }
        List<Books>collection5 = new ArrayList<>();
        for (int i = 20; i <= 25; i++) {
            collection5.add(booksService.foundById(i));
        }

        this.userList.add(User.builder()
            .id(1).name("Sunny").age(25)
                .booksList(collection1)
                .build());

        this.userList.add(User.builder()
             .id(2).name("Laslo").age(30)
                .booksList(collection2)
                .build());

        this.userList.add(User.builder()
             .id(3).name("Capone").age(40)
                .booksList(collection3)
                .build());

        this.userList.add(User.builder()
             .id(4).name("Poquito").age(70)
                .booksList(collection4)
                .build());

        this.userList.add(User.builder()
             .id(5).name("Nacho").age(30)
                .booksList(collection5)
                .build());
    }

    @Override
    public List<User> findAll() {
        return userList;
    }



    public User findById(int id){
        User foundUser = null;
        for (User user:
             userList) {
           if(user.getId()==id) {
               foundUser  = user;
           }
        }
        return foundUser;
    }

}
