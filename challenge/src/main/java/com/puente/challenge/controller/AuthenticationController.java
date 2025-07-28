package com.puente.challenge.controller;

import com.puente.challenge.dto.authentication.request.AuthenticationRequestDto;
import com.puente.challenge.dto.authentication.request.RegisterRequestDto;
import com.puente.challenge.dto.authentication.response.AuthenticationResponseDto;
import com.puente.challenge.dto.authentication.response.RegisterResponseDto;
import com.puente.challenge.service.AuthenticationService;
import com.puente.challenge.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    private final AuthenticationService authenticationService;

    private final RegisterService registerService;

    @PostMapping(path = "/authenticate",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticationResponseDto> authenticate (@RequestBody AuthenticationRequestDto authRequest) {
        logger.info(authRequest.toString());
        return ResponseEntity.ok(authenticationService.authenticate(authRequest));
    }

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisterResponseDto> register (@RequestBody RegisterRequestDto registerRequest) {
        logger.info(registerRequest.toString());
        return ResponseEntity.ok(registerService.register(registerRequest));
    }
}
