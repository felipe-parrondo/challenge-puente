package com.puente.challenge.dto.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GlobalQuoteDto implements Serializable {

    @JsonProperty("Global Quote")
    private QuoteDataDto globalQuote;
}
