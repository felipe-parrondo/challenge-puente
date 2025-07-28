package com.puente.challenge.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public record GetUserDataResponseDto (

        String email,

        @JsonProperty("full-name")
        String fullName,

        String age,

        String address

) implements Serializable {}
