package com.puente.challenge.controller;

import com.puente.challenge.dto.instrument.GetAvailableSymbolsResponseDto;
import com.puente.challenge.dto.instrument.GetSymbolResponseDto;
import com.puente.challenge.model.SymbolsEnum;
import com.puente.challenge.service.GetAvailableSymbolsService;
import com.puente.challenge.service.GetSymbolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instruments")
@RequiredArgsConstructor
public class InstrumentsController {

    private final GetAvailableSymbolsService getAvailableSymbolsService;

    private final GetSymbolService getSymbolService;

    @GetMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetAvailableSymbolsResponseDto> getAvailableSymbols () {
        return ResponseEntity.ok(getAvailableSymbolsService.getAvailableSymbols());
    }

    @GetMapping(path = "/{symbol}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetSymbolResponseDto> getSymbol (@PathVariable SymbolsEnum symbol) {
        return ResponseEntity.ok(getSymbolService.getSymbol(symbol.toString()));
    }
}
