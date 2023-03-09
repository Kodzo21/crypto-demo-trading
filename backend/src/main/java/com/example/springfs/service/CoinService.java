package com.example.springfs.service;

import com.example.springfs.model.Coin;
import com.example.springfs.repository.CoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoinService  {

    private final CoinRepository coinRepository;

    public void saveAll(List<Coin> coins){
        coinRepository.saveAll(coins);
    }

    public Optional<Coin> findById(String id) {
        return coinRepository.findById(id);
    }
}
