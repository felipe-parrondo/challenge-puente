package com.puente.challenge.controller;

import com.puente.challenge.dto.user.GetUserDataResponseDto;
import com.puente.challenge.dto.user.UpdateUserRequestDto;
import com.puente.challenge.service.GetMyUserService;
import com.puente.challenge.service.GetUserService;
import com.puente.challenge.service.UpdateUserService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UpdateUserService updateUserService;

    private final GetUserService getUserService;

    private final GetMyUserService getMyUserService;

    @PreAuthorize("hasRole('ADMIN') or #request.email == authentication.principal.username")
    @PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser (UpdateUserRequestDto updateUserRequestDto) {
        updateUserService.updateUser(updateUserRequestDto);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetUserDataResponseDto> getUserData (@RequestParam("email")
                                                               @NotBlank(message = "email must not be blank or null")
                                                               String email) {
        return ResponseEntity.ok(getUserService.getUser(email));
    }

    @GetMapping(path = "/me", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetUserDataResponseDto> getMyData () {
        return ResponseEntity.ok(getMyUserService.getMyUser());
    }
}
