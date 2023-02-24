package com.example.springfs.repository;

import com.example.springfs.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CoinRepository extends JpaRepository<Coin,String> {

}
