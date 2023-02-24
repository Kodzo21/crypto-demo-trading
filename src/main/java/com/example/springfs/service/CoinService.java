package com.example.springfs.service;

import com.example.springfs.model.Coin;
import com.example.springfs.repository.CoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoinService  {

    private final CoinRepository coinRepository;

    public void saveAll(List<Coin> coins){
        coinRepository.saveAll(coins);
    }
}
