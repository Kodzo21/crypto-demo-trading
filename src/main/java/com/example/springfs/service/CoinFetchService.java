package com.example.springfs.service;


import com.example.springfs.model.Coin;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class CoinFetchService {

    private final CoinService coinService;
    private final WebClient webClient =  WebClient.builder()
            .baseUrl("https://api.coingecko.com/api/v3")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    @EventListener(ApplicationReadyEvent.class)
    public void coinInit(){
        getWebClientRequest()
                .retrieve()
                .bodyToFlux(Coin.class)
                .collectList()
                .subscribe(coinService::saveAll);
    }

    @Scheduled(fixedRate = 60000)

    private WebClient.RequestHeadersSpec<?> getWebClientRequest(){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/coins/markets")
                        .queryParam("vs_currency","usd")
                        .queryParam("order","market_cap_desc")
                        .queryParam("per_page","200")
                        .queryParam("page","1")
                        .queryParam("price_change_percentage","1h,24h")
                        .build()
                );
    }
}
