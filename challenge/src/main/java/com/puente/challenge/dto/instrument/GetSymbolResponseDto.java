package com.puente.challenge.dto.instrument;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record GetSymbolResponseDto(

        String symbol,               // e.g. “AAPL”
        LocalDate lastTradingDay,    // e.g. 2025‑07‑25

        BigDecimal currentPrice,     // “05. price”
        BigDecimal change,           // “09. change”
        String changePercent,        // “10. change percent”
        Long volume,                 // “06. volume”

        BigDecimal open,             // “1. open”
        BigDecimal high,             // “2. high”
        BigDecimal low,              // “3. low”
        BigDecimal close,            // “4. close”

        List<DailyCloseDto> recentCloses

) implements Serializable {}
