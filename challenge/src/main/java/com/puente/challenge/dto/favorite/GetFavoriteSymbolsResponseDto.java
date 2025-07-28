package com.puente.challenge.dto.favorite;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public record GetFavoriteSymbolsResponseDto(

        @JsonProperty("favorite-list")
        List<String> favoriteList

) implements Serializable {}
