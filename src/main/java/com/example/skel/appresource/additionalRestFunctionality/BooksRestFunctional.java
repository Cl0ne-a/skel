package com.example.skel.appresource.additionalRestFunctionality;

import com.example.skel.domain.Books;
import com.example.skel.domain.User;
import com.example.skel.services.BooksService;
import com.example.skel.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BooksRestFunctional {

    private final BooksService booksService;

    @GetMapping
    public List <Books> findAll(){
        return this.booksService.findAll();
    }

    @GetMapping("/{bookId}")
    public Books findBookById(@PathVariable("bookId") int id){
        return this.booksService.foundById(id);}
}
