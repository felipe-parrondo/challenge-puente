package com.puente.challenge.mapper;

import com.puente.challenge.dto.user.GetUserDataResponseDto;
import com.puente.challenge.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class GetUserDataMapper {

    public GetUserDataResponseDto modelToDto (UserModel userModel) {
        return new GetUserDataResponseDto(
                userModel.getAuthentication().getEmail(),
                userModel.getFullName(),
                userModel.getAge(),
                userModel.getAddress()
        );
    }
}
