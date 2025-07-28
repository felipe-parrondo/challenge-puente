package com.puente.challenge.repository;

import com.puente.challenge.model.AuthenticationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthenticationRepository extends JpaRepository<AuthenticationModel, Long> {
    Optional<AuthenticationModel> findByEmail(String email);
}
