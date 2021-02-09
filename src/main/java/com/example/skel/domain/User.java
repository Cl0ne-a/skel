package com.example.skel.domain;

import lombok.*;

import org.springframework.stereotype.Component;
import java.util.List;
@Component
@Builder
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class User {

    private int id;
    private String name;
    private int age;

    private List<Books> booksList;


    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, List<Books> booksList) {
        this.name = name;
        this.age = age;
        this.booksList = booksList;
    }

}
