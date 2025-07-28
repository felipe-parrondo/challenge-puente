package com.puente.challenge.dto.authentication.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.puente.challenge.model.RoleEnum;

import java.io.Serializable;

public record RegisterRequestDto (

        String email,

        String password,

        RoleEnum role,

        @JsonProperty("full-name")
        String fullName,

        String age,

        String address

) implements Serializable {}
