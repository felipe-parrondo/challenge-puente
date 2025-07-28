package com.puente.challenge.service.implementation;

import com.puente.challenge.dto.user.GetUserDataResponseDto;
import com.puente.challenge.mapper.GetUserDataMapper;
import com.puente.challenge.service.GetCurrentUserService;
import com.puente.challenge.service.GetMyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMyUserServiceImplementation implements GetMyUserService {

    private final GetCurrentUserService getCurrentUserService;

    private final GetUserDataMapper getUserDataMapper;

    public GetUserDataResponseDto getMyUser () {
        return getUserDataMapper.modelToDto(getCurrentUserService.getUser());
    }
}
