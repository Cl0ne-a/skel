package com.example.skel.domain;

import lombok.*;

import org.springframework.stereotype.Component;
import java.util.List;
//@Component
//@Builder
//@Getter @Setter @EqualsAndHashCode @ToString
//@NoArgsConstructor @AllArgsConstructor

@Component
@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
public class User {

    private int id;
    private String name;
    private int age;
    private List<Books> booksList;
}
