package com.example.skel.services;

import com.example.skel.domain.Books;
import com.example.skel.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestResource(path = "/api/user")
public interface UserService {

    List< User>  findAll();

    User findById(int id);



}
