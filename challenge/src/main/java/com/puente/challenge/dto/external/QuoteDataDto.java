package com.puente.challenge.dto.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteDataDto implements Serializable {

    @JsonProperty("01. symbol")
    private String symbol;

    @JsonProperty("02. open")
    private BigDecimal open;

    @JsonProperty("03. high")
    private BigDecimal high;

    @JsonProperty("04. low")
    private BigDecimal low;

    @JsonProperty("05. price")
    private BigDecimal price;

    @JsonProperty("06. volume")
    private Long volume;

    @JsonProperty("07. latest trading day")
    private String latestTradingDay;

    @JsonProperty("08. previous close")
    private BigDecimal previousClose;

    @JsonProperty("09. change")
    private BigDecimal change;

    @JsonProperty("10. change percent")
    private String changePercent;
}
