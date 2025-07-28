package com.puente.challenge.service.implementation;

import com.puente.challenge.config.JwtService;
import com.puente.challenge.dto.authentication.request.AuthenticationRequestDto;
import com.puente.challenge.dto.authentication.response.AuthenticationResponseDto;
import com.puente.challenge.model.AuthenticationModel;
import com.puente.challenge.repository.AuthenticationRepository;
import com.puente.challenge.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImplementation implements AuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final AuthenticationRepository authenticationRepository;

    @Override
    public AuthenticationResponseDto authenticate(AuthenticationRequestDto authenticationRequestDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequestDto.email(), authenticationRequestDto.password()));

        AuthenticationModel authModel = authenticationRepository.findByEmail(authenticationRequestDto.email())
                .orElseThrow(() -> new NoSuchElementException("user doesn't exist"));

        return new AuthenticationResponseDto(jwtService.generateToken(authModel));
    }
}
