package com.jhonatan.helloworld.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jhonatan.helloworld.application.service.PersonService;
import com.jhonatan.helloworld.domain.Rol;
import com.jhonatan.helloworld.domain.person;


import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    private final PersonService personService;

    public ApiController(@Qualifier("personServiceImpl")PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/users")    
    public List<person> findAllUser(
        @RequestParam(name= "filter", defaultValue = "")String filter,
        @RequestParam(name="value",defaultValue = "")String value
    ){
        List<person> results = personService.findAllUsersByFilter(filter, value);
        return results;
    }

    @GetMapping("/roles")    
    public List<Rol> findAllRoles(
        @RequestParam(name= "filter", defaultValue = "")String filter,
        @RequestParam(name="value",defaultValue = "")String value
    ){
        List<Rol> results = personService.findAllRolesByFiler(filter, value);
        return results;
    }

}
