package com.puente.challenge.controller;

import com.puente.challenge.dto.favorite.GetFavoriteSymbolsResponseDto;
import com.puente.challenge.model.SymbolsEnum;
import com.puente.challenge.service.AddFavoriteSymbolService;
import com.puente.challenge.service.DeleteFavoriteSymbolService;
import com.puente.challenge.service.GetFavoriteSymbolsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favorites")
@RequiredArgsConstructor
public class FavoritesController {

    private final AddFavoriteSymbolService addFavoriteSymbolService;

    private final DeleteFavoriteSymbolService deleteFavoriteSymbolService;

    private final GetFavoriteSymbolsService getFavoriteSymbolsService;

    @PostMapping(path = "/{symbol}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addFavoriteSymbol (@PathVariable SymbolsEnum symbol) {
        addFavoriteSymbolService.addFavoriteSymbol(symbol.toString());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{symbol}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteFavoriteSymbol (@PathVariable SymbolsEnum symbol) {
        deleteFavoriteSymbolService.deleteFavoriteSymbol(symbol.toString());
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetFavoriteSymbolsResponseDto> getFavoriteSymbols () {
        return ResponseEntity.ok(getFavoriteSymbolsService.getFavoriteSymbol());
    }
}
