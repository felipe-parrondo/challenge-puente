package com.puente.challenge.dto.authentication.request;

import java.io.Serializable;

public record AuthenticationRequestDto (

        String email,

        String password

) implements Serializable {}
