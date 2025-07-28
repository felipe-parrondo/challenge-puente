package com.puente.challenge.external;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("alphavantage")
@Data
public class AlphaVantageProperties {
    private String baseUrl;
    private String apiKey;
}
