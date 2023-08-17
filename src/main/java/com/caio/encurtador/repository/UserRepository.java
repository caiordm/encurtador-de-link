package com.caio.encurtador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caio.encurtador.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
