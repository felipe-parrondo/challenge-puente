package com.puente.challenge.dto.authentication.response;

import java.io.Serializable;

public record RegisterResponseDto (

        String token

) implements Serializable {}
