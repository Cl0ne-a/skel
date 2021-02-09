package com.example.skel.appresource;

import com.example.skel.domain.Author;
import com.example.skel.domain.User;
import com.example.skel.services.AuthorService;
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
@RequestMapping("/api/author")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthorRestFunctional {
    public AuthorService authorService;

    @GetMapping("/")
    public List<Author> findAll(){
        return this.authorService.findAll();
    }
}
