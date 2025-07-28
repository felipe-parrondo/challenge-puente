package com.puente.challenge.dto.authentication.response;

import java.io.Serializable;

public record AuthenticationResponseDto (

        String token

) implements Serializable {}
