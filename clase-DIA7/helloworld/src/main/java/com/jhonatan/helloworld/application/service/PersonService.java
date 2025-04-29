package com.jhonatan.helloworld.application.service;

import java.util.List;

import com.jhonatan.helloworld.domain.Rol;
import com.jhonatan.helloworld.domain.person;


public interface PersonService {

    public List<person> findAllUsersByFilter(String filter, String value);
    public List<Rol> findAllRolesByFiler(String filter, String value);
}

   
    
