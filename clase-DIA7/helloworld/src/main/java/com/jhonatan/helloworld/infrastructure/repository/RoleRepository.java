package com.jhonatan.helloworld.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhonatan.helloworld.domain.Rol;

public interface RoleRepository extends JpaRepository<Rol, Long> {
    
}
