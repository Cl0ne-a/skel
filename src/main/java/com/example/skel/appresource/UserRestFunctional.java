package com.example.skel.appresource;
import com.example.skel.domain.Books;
import com.example.skel.domain.User;
import com.example.skel.services.UserService;
import com.example.skel.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserRestFunctional {

    private final UserService userService;

//    @Autowired
//    public UserRestFunctional(UserService userServiceImpl) {
//        userService = userServiceImpl;
//    }

    @GetMapping
    public List<User> findAll(){
        log.info("****REST PLACE INIT****");
        return this.userService.findAll();
    }

    @GetMapping("/distinctUsers")
    public List <String> distinctByName(){
        return this.userService.distinctByNameWithBookList();
    }

    //Does not function with error 500
    @GetMapping("/{authorId}")
    public int userEverageAge(@PathVariable("authorId") int authorId) {
        return this.userService.userAge(authorId);
    }

    @GetMapping("/{userId}")
    public User findById(@PathVariable("userId") int userId){
        return this.userService.findById(userId);
    }

    @GetMapping("/age/{minAge}")
    public List <String> findAllOlder(@PathVariable("minAge") int minAge){
        return this.userService.findByAge(minAge);
    }
    
    @GetMapping("/count")
    public int countBy(){
        return this.userService.countBy();
    }

    @GetMapping("/bookslist")
    public List <String> booksWithAuthorAlive(){
        return this.userService.booksWithAuthorAlive();
    }


}
