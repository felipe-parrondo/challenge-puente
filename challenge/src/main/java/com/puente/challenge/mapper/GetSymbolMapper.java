package com.puente.challenge.mapper;

import com.puente.challenge.dto.external.DailyPriceDto;
import com.puente.challenge.dto.external.GlobalQuoteDto;
import com.puente.challenge.dto.external.QuoteDataDto;
import com.puente.challenge.dto.external.TimeSeriesDailyDto;
import com.puente.challenge.dto.instrument.DailyCloseDto;
import com.puente.challenge.dto.instrument.GetSymbolResponseDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class GetSymbolMapper {

    public GetSymbolResponseDto mapToOverview(TimeSeriesDailyDto ts, GlobalQuoteDto gq) {
        String symbol = gq.getGlobalQuote().getSymbol();
        LocalDate tradingDay = LocalDate.parse(gq.getGlobalQuote().getLatestTradingDay());
        QuoteDataDto q = gq.getGlobalQuote();
        DailyPriceDto dp = ts.getTimeSeriesDaily().get(tradingDay.toString());

        List<DailyCloseDto> spark = ts.getTimeSeriesDaily().entrySet().stream()
                .sorted(Map.Entry.<String, DailyPriceDto>comparingByKey().reversed())
                .limit(7)
                .map(e -> new DailyCloseDto(LocalDate.parse(e.getKey()), e.getValue().getClose()))
                .collect(Collectors.toList());

        return new GetSymbolResponseDto(
                symbol,
                tradingDay,
                q.getPrice(),
                q.getChange(),
                q.getChangePercent(),
                q.getVolume(),
                dp.getOpen(),
                dp.getHigh(),
                dp.getLow(),
                dp.getClose(),
                spark
        );
    }
}
