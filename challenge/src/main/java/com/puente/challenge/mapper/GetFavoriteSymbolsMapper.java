package com.puente.challenge.mapper;

import com.puente.challenge.dto.favorite.GetFavoriteSymbolsResponseDto;
import com.puente.challenge.model.FavoriteSymbolsModel;
import org.springframework.stereotype.Component;

@Component
public class GetFavoriteSymbolsMapper {

    public GetFavoriteSymbolsResponseDto modelToDto (FavoriteSymbolsModel favoriteSymbolsModel) {
        return new GetFavoriteSymbolsResponseDto(favoriteSymbolsModel.getFavoriteSymbols().stream().toList());
    }

}