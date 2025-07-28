package com.puente.challenge.config;

import com.puente.challenge.external.AlphaVantageApiClient;
import com.puente.challenge.model.SymbolsEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StockCacheRefresher {

    private final CacheManager cacheManager;
    private final AlphaVantageApiClient alphaVantageApiClient;

    @Scheduled(fixedRate = 5 * 60 * 1000)
    public void evictAllAndReload() {
        Cache cache = cacheManager.getCache("stocks");
        if (cache != null) {
            cache.clear();
            List<String> stockSymbols = Arrays.stream(SymbolsEnum.values())
                            .map(Enum::toString)
                            .toList();

            stockSymbols.forEach(alphaVantageApiClient::getTimeSeriesDaily);
        }
    }
}
