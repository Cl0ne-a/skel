To run the app:

Jasypt encryption:
Configuration through src/main/resources/application.properties
#mvn -Djasypt.encryptor.password=mySecretKeyToEncryptPassword spring-boot:run

Dependencies rough list:
   one.util:streamex
   org.springframework.boot:spring-boot-starter-web
   EXCLUDED: org.springframework.boot:spring-boot-starter-tomcat
   org.springframework.boot:spring-boot-starter-jetty
   org.springframework.boot:spring-boot-starter-actuator
   com.github.ulisesbocchio:jasypt-spring-boot-starter
   org.projectlombok:lombok
   org.springframework.boot:spring-boot-starter-test
   junit:junit


   Repositories: src/main/java/com/example/skel/services: UserService, BooksService, AuthorService
   Data resource: src/main/java/com/example/skel/services/impl: UserServiceImpl, BooksServiceImpl, AuthorServiceImpl
   Domains: src/main/java/com/example/skel/domain: User, Books, Author


   Rest API: src/main/java/com/example/skel/appresource
   1. Get books name with user older than 25 and author alive
   #curl http://localhost:80/api/users/bookslist

   2. Count users with over 2 booklist, users older than 2002
   #curl http://localhost:80/api/users/count

   3. Users older than 20 y.o. and booklist over 5 items
   #curl http://localhost:80/api/users/age/20

   4. Count everage user age by Author (input Author Id which is 1 - 5
   #curl http://localhost:80/api/users/5

   5. Distinct user names with bookslist over 2 item
   #curl http://localhost:80/api/users/distinctUsers

   Created:
   Users:
   id(1).name("Sunny").age(25)
   id(2).name("Laslo").age(30)
   id(3).name("Capone").age(40)
   id(4).name("Poquito").age(70)
   id(5).name("Nacho").age(31)
   id(6).name("Bambino").age(15)
   id(6).name("Bambino").age(15)

   Books: 25 items (sorted to collections in UserServiceImpl.javva)

   Authors:
   id(1).firstName("Auth1").lastName("Auth1").birthday(new Date(60, 5, 5))
   id(2).firstName("Auth2").lastName("Auth2").birthday(new Date(15, 5, 5)).deathday(new Date(100, 8,1))
   id(3).firstName("Auth3").lastName("Auth3").birthday(new Date(30, 5, 5))
   id(4).firstName("Auth4").lastName("Auth4").birthday(new Date(10, 5, 5)).deathday(new Date(100, 8,1))
   id(5).firstName("Auth5").lastName("Auth5").birthday(new Date(0, 5, 5)).deathday(new Date(70, 8,1))


