package com.puente.challenge.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public record UpdateUserRequestDataDto (

        @JsonProperty("full-name")
        String fullName,

        String age,

        String address

) implements Serializable {}
