package com.jhonatan.helloworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonatan.helloworld.domain.person;

public interface PersonRepository extends JpaRepository<person, Long> {
    List<person> findBynameContains(String name);
}
