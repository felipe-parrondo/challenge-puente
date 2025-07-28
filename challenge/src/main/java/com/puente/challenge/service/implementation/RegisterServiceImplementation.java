package com.puente.challenge.service.implementation;

import com.puente.challenge.config.ConstraintViolationsUtils;
import com.puente.challenge.config.JwtService;
import com.puente.challenge.dto.authentication.request.RegisterRequestDto;
import com.puente.challenge.dto.authentication.response.RegisterResponseDto;
import com.puente.challenge.exception.EmailAlreadyInUseException;
import com.puente.challenge.model.AuthenticationModel;
import com.puente.challenge.model.UserModel;
import com.puente.challenge.repository.AuthenticationRepository;
import com.puente.challenge.repository.UserRepository;
import com.puente.challenge.service.AuthenticationService;
import com.puente.challenge.service.RegisterService;

import lombok.RequiredArgsConstructor;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterServiceImplementation implements RegisterService {

    private final AuthenticationRepository authenticationRepository;

    private final UserRepository userRepository;

    private final AuthenticationService authenticationService;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponseDto register(RegisterRequestDto registerRequestDto) {
        try {
            AuthenticationModel authModel = AuthenticationModel.builder()
                    .email(registerRequestDto.email())
                    .password(passwordEncoder.encode(registerRequestDto.password()))
                    .role(registerRequestDto.role())
                    .build();
            authModel = authenticationRepository.save(authModel);
            UserModel userModel = UserModel.builder()
                    .fullName(registerRequestDto.fullName())
                    .age(registerRequestDto.age())
                    .address(registerRequestDto.address())
                    .authentication(authModel)
                    .build();
            userRepository.save(userModel);
            return new RegisterResponseDto(jwtService.generateToken(authModel));
        } catch (ConstraintViolationException e) {
            if (ConstraintViolationsUtils.isConstraintViolationOnField(e, "email")) {
                throw new EmailAlreadyInUseException("Email already registered");
            }
            throw new ConstraintViolationException(e.getMessage(), e.getSQLException(), e.getConstraintName());
        }
    }
}
