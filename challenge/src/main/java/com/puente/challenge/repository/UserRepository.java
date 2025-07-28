package com.puente.challenge.repository;

import com.puente.challenge.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByAuthenticationEmail (String email);
}