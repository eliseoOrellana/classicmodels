package io.eliseoorellana.classicmodels.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.eliseoorellana.classicmodels.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username); 
}
