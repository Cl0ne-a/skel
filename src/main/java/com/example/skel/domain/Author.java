package com.example.skel.domain;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
@NoArgsConstructor @AllArgsConstructor
@Data
@Builder
public class Author {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private Date deathday;
}
