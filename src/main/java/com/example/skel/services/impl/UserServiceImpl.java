package com.example.skel.services.impl;

import com.example.skel.domain.Author;
import com.example.skel.domain.Books;
import com.example.skel.domain.User;
import com.example.skel.services.BooksService;
import com.example.skel.services.UserService;
import com.sun.el.stream.Stream;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import one.util.streamex.StreamEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Log
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService{
    @Autowired
    BooksServiceImpl booksService;


    private List<User> userList = new ArrayList<>();
    private List<String> distincts = new ArrayList<>();


    @PostConstruct
    public void postConstructUsers(){
        log.info("USER POSTCONSTRUCT");
        List<Books>collection1 = new ArrayList<>();
        for (int i = 1; i<3; i++) {
            collection1.add(booksService.foundById(i));
        }
        List<Books>collection2 = new ArrayList<>();
        for (int i = 3; i < 10; i++) {
            collection2.add(booksService.foundById(i));
        }
        List<Books>collection3 = new ArrayList<>();
        for (int i = 10; i < 15; i++) {
            collection3.add(booksService.foundById(i));
        }
        List<Books>collection4 = new ArrayList<>();
        for (int i = 15; i < 20; i++) {
            collection4.add(booksService.foundById(i));
        }
        List<Books>collection5 = new ArrayList<>();
        for (int i = 20; i <= 25; i++) {
            collection5.add(booksService.foundById(i));
        }

        this.userList.add(User.builder()
            .id(1).name("Sunny").age(25)
                .booksList(collection1)
                .build());

        this.userList.add(User.builder()
             .id(2).name("Laslo").age(30)
                .booksList(collection2)
                .build());

        this.userList.add(User.builder()
             .id(3).name("Capone").age(40)
                .booksList(collection3)
                .build());

        this.userList.add(User.builder()
             .id(4).name("Poquito").age(70)
                .booksList(collection4)
                .build());

        this.userList.add(User.builder()
             .id(5).name("Nacho").age(31)
                .booksList(collection5)
                .build());
        //no books in collection
        this.userList.add(User.builder()
             .id(6).name("Bambino").age(15)
                .booksList(collection1).build());

        this.userList.add(User.builder()
                .id(6).name("Bambino").age(15)
                .booksList(collection1).build());
    }

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public List<String> distinctByNameWithBookList(){
        List<User> distinctUsers = StreamEx.of(this.userList.stream().filter(user -> user.getBooksList().size()>2).collect(Collectors.toList())).distinct(User::getName).toList();
        for (User user: distinctUsers) {
            distincts.add(user.getName());
        }
        return distincts;
    }

    @Override
    public int userAge(int authorId) {
        int countUsers = 0;
        int countUserAge = 0;
       //Checking each user's books list fo certain author, counting occurrences, and adding age.
        //Didn't come up with lambda version :(
        for (User user : userList) {
            for(Books book: user.getBooksList()){
                if (book.getAuthor().getId()==authorId){
                   countUsers++;
                   countUserAge = countUserAge+user.getAge();
               }
            }
        }
        return countUserAge/countUsers;
    }

    @Override
    public List <String> booksWithAuthorAlive() {
        //Filtering users by age
        List<User>list = this.userList.stream().filter(user -> user.getAge()>25).collect(Collectors.toList());
        //Filtering 'filtered' users' books lists for books with authors alive;
        List<Books> bigBooksList = list.stream().flatMap(user -> user.getBooksList().stream()).collect(Collectors.toList());

        //Retrieving books names;
        return bigBooksList.stream().filter(books -> books.getAuthor().getDeathday()==null).collect(Collectors.toList())
                .stream().map(Books::getName).collect(Collectors.toList());
    }

    @Override
    public int countBy() {
        int age = LocalDate.now().getYear() - 2002;
        //Filtering and counting users by date of birth and booklist size
        int count = (int) this.userList.stream().filter(user -> user.getAge()>(age)&&user.getBooksList().size()>2).count();
        return count;
    }

    @Override
    public List<String> findByAge(int minAge) {
        //Retrieving users names filter minimum age and booklist size
        return this.userList.stream().filter(user -> user.getAge()>minAge&&user.getBooksList().size()>5)
                .collect(Collectors.toList()).stream().map(User::getName).collect(Collectors.toList());
    }

    @Override
    public User findById(int id){
        log.info("UserService: execute findOne(userId) method");
        return this.userList.stream()
                .filter(user -> user.getId()==(id))
                .findFirst()
                .orElse(null);

    }

}
