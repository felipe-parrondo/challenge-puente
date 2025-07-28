package com.puente.challenge.dto.instrument;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public record DailyCloseDto (

        LocalDate date,
        BigDecimal close

) implements Serializable {}
