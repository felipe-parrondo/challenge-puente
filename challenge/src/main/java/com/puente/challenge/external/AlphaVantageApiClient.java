package com.puente.challenge.external;

import com.puente.challenge.dto.external.GlobalQuoteDto;
import com.puente.challenge.dto.external.TimeSeriesDailyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class AlphaVantageApiClient {

    private final RestTemplate restTemplate;
    private final AlphaVantageProperties props;

    @Cacheable(value = "stocks", key = "#symbol")
    public TimeSeriesDailyDto getTimeSeriesDaily(String symbol) {
        return callApi("TIME_SERIES_DAILY", symbol, TimeSeriesDailyDto.class);
    }

    @Cacheable(value = "quotes", key = "#symbol")
    public GlobalQuoteDto getGlobalQuote(String symbol) {
        return callApi("GLOBAL_QUOTE", symbol, GlobalQuoteDto.class);
    }

    private <T> T callApi(String function, String symbol, Class<T> responseType) {
        String uri = UriComponentsBuilder
                .fromUriString(props.getBaseUrl())
                .queryParam("function", function)
                .queryParam("symbol", symbol)
                .queryParam("apikey", props.getApiKey())
                .encode()
                .toUriString();

        return restTemplate.getForObject(uri, responseType);
    }
}
