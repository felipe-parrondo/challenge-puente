package com.puente.challenge.service;

import com.puente.challenge.dto.authentication.request.RegisterRequestDto;
import com.puente.challenge.dto.authentication.response.RegisterResponseDto;

public interface RegisterService {
    RegisterResponseDto register (RegisterRequestDto registerRequestDto);
}
