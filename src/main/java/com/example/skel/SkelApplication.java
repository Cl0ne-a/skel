package com.example.skel;

import com.example.skel.configs.ApplicationJasypt;
import com.example.skel.configs.ApplicationProperties;
import com.example.skel.domain.Author;
import com.example.skel.domain.Books;
import com.example.skel.domain.User;
import com.example.skel.services.AuthorService;
import com.example.skel.services.BooksService;
import com.example.skel.services.UserService;
import com.example.skel.services.impl.BooksServiceImpl;
import com.example.skel.services.impl.UserServiceImpl;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
@EnableEncryptableProperties
public class SkelApplication {


//    @Autowired
//    private UserServiceImpl userService1;

    public static void main(String[] args) {
        SpringApplication springApp = new SpringApplication((SkelApplication.class));
                springApp.run(args);
                log.info("*************************************");
                log.info("************ MAIN marker ************");
                log.info("*************************************");

    }




    @Bean
    public CommandLineRunner runner (UserService userService, BooksService booksService, AuthorService authorService){
        return args -> {
            log.info("************ Runner ************");
            log.info("Users registered" );


//
//            userService1.postConstructUsers();

            for (User user:
                 userService.findAll()) {
                 log.info(user.toString());
            }

            log.info("Books registered" );

            for (Books book:
                 booksService.findAll() ) {
                log.info(book.toString());
            }


            log.info("Authors registered" );
            for (Author author:
                 authorService.findAll()) {
                log.info(author.toString());
            }
        };
    }

}
