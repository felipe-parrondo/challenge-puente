package com.puente.challenge.service.implementation;

import com.puente.challenge.dto.user.GetUserDataResponseDto;
import com.puente.challenge.mapper.GetUserDataMapper;
import com.puente.challenge.repository.UserRepository;
import com.puente.challenge.service.GetUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GetUserServiceImplementation implements GetUserService {

    private final UserRepository userRepository;

    private final GetUserDataMapper getUserDataMapper;

    @Override
    public GetUserDataResponseDto getUser(String email) {
        return getUserDataMapper.modelToDto(
                userRepository.findByAuthenticationEmail(email)
                        .orElseThrow(() -> new NoSuchElementException("user not found"))
        );
    }
}
