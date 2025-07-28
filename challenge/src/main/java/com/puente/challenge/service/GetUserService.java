package com.puente.challenge.service;

import com.puente.challenge.dto.user.GetUserDataResponseDto;

public interface GetUserService {
    GetUserDataResponseDto getUser (String email);
}
