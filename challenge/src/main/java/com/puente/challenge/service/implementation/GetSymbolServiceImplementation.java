package com.puente.challenge.service.implementation;

import com.puente.challenge.dto.external.GlobalQuoteDto;
import com.puente.challenge.dto.external.QuoteDataDto;
import com.puente.challenge.dto.external.TimeSeriesDailyDto;
import com.puente.challenge.dto.instrument.GetSymbolResponseDto;
import com.puente.challenge.external.AlphaVantageApiClient;
import com.puente.challenge.mapper.GetSymbolMapper;
import com.puente.challenge.service.GetSymbolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetSymbolServiceImplementation implements GetSymbolService {

    private final AlphaVantageApiClient alphaVantageApiClient;

    private final GetSymbolMapper getSymbolMapper;

    @Override
    public GetSymbolResponseDto getSymbol(String symbol) {
        GlobalQuoteDto globalQuote = alphaVantageApiClient.getGlobalQuote(symbol);
        TimeSeriesDailyDto timeSeriesDaily = alphaVantageApiClient.getTimeSeriesDaily(symbol);

        return getSymbolMapper.mapToOverview(timeSeriesDaily, globalQuote);
    }
}
