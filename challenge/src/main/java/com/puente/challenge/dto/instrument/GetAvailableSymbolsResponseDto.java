package com.puente.challenge.dto.instrument;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public record GetAvailableSymbolsResponseDto (

        @JsonProperty("available-symbols")
        List<String> availableSymbols

) implements Serializable {}
