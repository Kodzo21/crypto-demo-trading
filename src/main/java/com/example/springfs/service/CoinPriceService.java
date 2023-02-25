package com.example.springfs.service;

import com.example.springfs.model.CoinPrice;
import com.example.springfs.repository.CoinPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoinPriceService {

    private final CoinPriceRepository coinPriceRepository;

    public void saveAll(List<CoinPrice> coinPriceList){
        coinPriceRepository.saveAll(coinPriceList);
    }
    public void save(CoinPrice coinPrice){
        coinPriceRepository.save(coinPrice);
    }
}
