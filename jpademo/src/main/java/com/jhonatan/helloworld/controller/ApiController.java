package com.jhonatan.helloworld.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonatan.helloworld.domain.person;
import com.jhonatan.helloworld.repository.PersonRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    private final PersonRepository personRepository;

    public ApiController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @GetMapping("users")    
    public List<person> findAll(){
        List<person> results= personRepository.findAll();
        return results;
    }

}
