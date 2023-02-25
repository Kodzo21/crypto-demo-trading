package com.example.springfs.repository;

import com.example.springfs.model.CoinPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;

public interface CoinPriceRepository extends JpaRepository<CoinPrice, Long> {

}
