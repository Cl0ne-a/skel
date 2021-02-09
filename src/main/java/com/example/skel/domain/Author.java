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
    private String firstName; // first name (string),
    private String lastName;// last name (string),
    private Date birthday;// DEPRECATED
    private Date deathday;// DEPRECATED (java.util.Date)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return firstName.equals(author.firstName) && lastName.equals(author.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
