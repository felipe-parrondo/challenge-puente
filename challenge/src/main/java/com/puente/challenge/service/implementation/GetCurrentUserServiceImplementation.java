package com.puente.challenge.service.implementation;

import com.puente.challenge.model.AuthenticationModel;
import com.puente.challenge.model.UserModel;
import com.puente.challenge.repository.AuthenticationRepository;
import com.puente.challenge.repository.UserRepository;
import com.puente.challenge.service.GetCurrentUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GetCurrentUserServiceImplementation implements GetCurrentUserService {

    private final UserRepository userRepository;

    @Override
    public UserModel getUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByAuthenticationEmail(email)
                .orElseThrow(() -> new NoSuchElementException("user not found"));
    }
}