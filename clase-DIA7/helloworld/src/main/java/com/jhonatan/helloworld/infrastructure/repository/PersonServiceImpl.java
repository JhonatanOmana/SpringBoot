package com.jhonatan.helloworld.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhonatan.helloworld.application.service.PersonService;
import com.jhonatan.helloworld.domain.Rol;
import com.jhonatan.helloworld.domain.person;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;

    public PersonServiceImpl(PersonRepository personRepository, RoleRepository roleRepository) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<person> findAllUsersByFilter(String filter, String value) {
        if (filter.toLowerCase().equals("name") && !value.isEmpty()) {
            return personRepository.findByNameContains(value);
        } else if (filter.toLowerCase().equals("language") && !value.isEmpty()) {
            return personRepository.findByLanguageEquals(value);
        }
        return personRepository.findAll();
    }

    @Override
    public List<Rol> findAllRolesByFiler(String filter, String value) {
        return roleRepository.findAll();
    }
}

