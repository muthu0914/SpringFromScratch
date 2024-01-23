package com.qwerty.learn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qwerty.learn.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {

	Optional<User> findByUserName(String username); 
}
