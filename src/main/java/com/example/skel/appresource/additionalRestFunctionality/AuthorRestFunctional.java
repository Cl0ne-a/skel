package com.example.skel.appresource.additionalRestFunctionality;

import com.example.skel.domain.Author;
import com.example.skel.services.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/author")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthorRestFunctional {
    private final AuthorService authorService;

    @GetMapping
    public List<Author> findAll(){
        return this.authorService.findAll();
    }

    @GetMapping("/{authorId}")
    public Author findAuthorById(@PathVariable ("authorId") int authorId){
        return this.authorService.findAuthorById(authorId);
    }
}
