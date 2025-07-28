package com.puente.challenge.service;

import com.puente.challenge.dto.instrument.GetSymbolResponseDto;

public interface GetSymbolService {
    GetSymbolResponseDto getSymbol (String symbol);
}
