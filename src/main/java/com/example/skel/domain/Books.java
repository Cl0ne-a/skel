package com.example.skel.domain;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
public class Books {

    private int id;
    private String name;
    private Author author;
    private Date publicationDate;

}
