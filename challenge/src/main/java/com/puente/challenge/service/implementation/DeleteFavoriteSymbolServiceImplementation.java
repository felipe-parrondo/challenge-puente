package com.puente.challenge.service.implementation;

import com.puente.challenge.model.FavoriteSymbolsModel;
import com.puente.challenge.model.SymbolsEnum;
import com.puente.challenge.repository.FavoriteSymbolsRepository;
import com.puente.challenge.service.DeleteFavoriteSymbolService;
import com.puente.challenge.service.GetCurrentUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class DeleteFavoriteSymbolServiceImplementation implements DeleteFavoriteSymbolService {

    private final GetCurrentUserService getCurrentUserService;

    private final FavoriteSymbolsRepository favoriteSymbolsRepository;

    @Override
    public void deleteFavoriteSymbol(String symbol) {
        String email = getCurrentUserService.getUser().getAuthentication().getEmail();
        FavoriteSymbolsModel favoriteSymbolsModel = favoriteSymbolsRepository.findByEmail(email)
                .orElseGet(() -> {
                    FavoriteSymbolsModel noFavorites = new FavoriteSymbolsModel();
                    noFavorites.setEmail(email);
                    noFavorites.setFavoriteSymbols(new HashSet<>());
                    return noFavorites;
                });
        favoriteSymbolsModel.getFavoriteSymbols().add(symbol);
        favoriteSymbolsRepository.save(favoriteSymbolsModel);
    }
}
