package com.puente.challenge.service.implementation;

import com.puente.challenge.dto.user.UpdateUserRequestDto;
import com.puente.challenge.model.UserModel;
import com.puente.challenge.repository.UserRepository;
import com.puente.challenge.service.UpdateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UpdateUserServiceImplementation implements UpdateUserService {

    private final UserRepository userRepository;

    @Override
    public void updateUser(UpdateUserRequestDto updateUserRequestDto) {
        UserModel userModel = userRepository.findByAuthenticationEmail(updateUserRequestDto.email())
                .orElseThrow(() -> new NoSuchElementException("user not found"));
        userModel.setAddress(updateUserRequestDto.userData().address());
        userModel.setAge(updateUserRequestDto.userData().age());
        userModel.setFullName(updateUserRequestDto.userData().fullName());
    }
}
