package com.puente.challenge.service;

import com.puente.challenge.dto.authentication.request.AuthenticationRequestDto;
import com.puente.challenge.dto.authentication.response.AuthenticationResponseDto;

public interface AuthenticationService {
    AuthenticationResponseDto authenticate (AuthenticationRequestDto authenticationRequestDto);
}
