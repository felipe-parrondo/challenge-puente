package com.puente.challenge.service.implementation;

import com.puente.challenge.dto.favorite.GetFavoriteSymbolsResponseDto;
import com.puente.challenge.mapper.GetFavoriteSymbolsMapper;
import com.puente.challenge.model.FavoriteSymbolsModel;
import com.puente.challenge.repository.FavoriteSymbolsRepository;
import com.puente.challenge.service.GetCurrentUserService;
import com.puente.challenge.service.GetFavoriteSymbolsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class GetFavoriteSymbolsServiceImplementation implements GetFavoriteSymbolsService {

    private final GetCurrentUserService getCurrentUserService;

    private final GetFavoriteSymbolsMapper getFavoriteSymbolsMapper;

    private final FavoriteSymbolsRepository favoriteSymbolsRepository;

    @Override
    public GetFavoriteSymbolsResponseDto getFavoriteSymbol() {
        return getFavoriteSymbolsMapper.modelToDto(
                favoriteSymbolsRepository.findByEmail(getCurrentUserService.getUser().getAuthentication().getEmail())
                        .orElseGet(() -> {
                            FavoriteSymbolsModel noFavorites = new FavoriteSymbolsModel();
                            noFavorites.setFavoriteSymbols(new HashSet<>());
                            return noFavorites;
                        })
        );
    }
}
