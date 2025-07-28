package com.puente.challenge.service.implementation;

import com.puente.challenge.dto.instrument.GetAvailableSymbolsResponseDto;
import com.puente.challenge.model.SymbolsEnum;
import com.puente.challenge.service.GetAvailableSymbolsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class GetAvailableSymbolsServiceImplementation implements GetAvailableSymbolsService {

    @Override
    public GetAvailableSymbolsResponseDto getAvailableSymbols() {
        return new GetAvailableSymbolsResponseDto(
                Arrays.stream(SymbolsEnum.values())
                        .map(SymbolsEnum::toString)
                        .toList()
        );
    }
}
