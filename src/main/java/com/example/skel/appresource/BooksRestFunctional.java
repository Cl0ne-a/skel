package com.example.skel.appresource;

import com.example.skel.domain.Books;
import com.example.skel.domain.User;
import com.example.skel.services.BooksService;
import com.example.skel.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BooksRestFunctional {

    BooksService booksService;

    @GetMapping("/")
    public List <Books> findAll(){
        return this.booksService.findAll();
    }

}
