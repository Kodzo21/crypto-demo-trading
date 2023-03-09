package com.example.springfs.service;


import com.example.springfs.config.CoinMarketResponse;
import com.example.springfs.model.Coin;
import com.example.springfs.model.CoinPrice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class CoinFetchService {

    private final CoinService coinService;
    private final CoinPriceService coinPriceService;
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


    @Scheduled(initialDelay = 5000,fixedRate = 60000)
    public void getCryptocurrencyUsdExchangeRate(){
        System.out.println("Start");
        getWebClientRequest()
                .retrieve()
                .bodyToFlux(CoinMarketResponse.class)
                .subscribe(coinM -> {
                    CoinPrice coinPrice = new CoinPrice();
                    coinService.findById(coinM.getId()).ifPresent(coinPrice::setCoin);
                     coinPrice.setVolume(coinM.getCurrent_price());
                     coinPriceService.save(coinPrice);
                });
    }

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
