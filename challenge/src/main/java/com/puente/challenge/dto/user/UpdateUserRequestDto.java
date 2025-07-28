package com.puente.challenge.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public record UpdateUserRequestDto (

        String email,

        @JsonProperty("user-data")
        UpdateUserRequestDataDto userData

) implements Serializable {}
