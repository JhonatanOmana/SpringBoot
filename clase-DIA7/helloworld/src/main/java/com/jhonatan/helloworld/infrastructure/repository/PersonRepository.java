package com.jhonatan.helloworld.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonatan.helloworld.domain.person;

public interface PersonRepository extends JpaRepository<person, Long> {
    List<person> findByNameContains(String name);
    List<person> findByLanguageEquals(String name);
}
