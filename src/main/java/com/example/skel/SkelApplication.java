package com.example.skel;


import com.example.skel.configs.ApplicationProperties;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Slf4j
@EnableConfigurationProperties(ApplicationProperties.class)
@EnableEncryptableProperties
@SpringBootApplication
public class SkelApplication {

    public static void main(String[] args) {
        SpringApplication springApp = new SpringApplication((SkelApplication.class));
                springApp.run(args);

    }

//    @Bean
//    public CommandLineRunner runner (UserService userService, BooksService booksService, AuthorService authorService){
//        return args -> {
//            this Bean is crearated to test accessibility or elements, methods and results
//            log.info("************ Tester ************");
//
//            Tested code, like that:

//            int i = userService.userAge(1);
//            log.info("Age " + i);
//        };
//    }
}

