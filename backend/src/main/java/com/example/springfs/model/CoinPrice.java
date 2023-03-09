package com.example.springfs.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CoinPrice {

    @Id
    @GeneratedValue
    private Long priceID;

    @Column(name="volume",precision = 20,scale = 6)
    private BigDecimal volume;

    private Timestamp time;

    @ManyToOne
    @JoinColumn(name = "coin_id")
    private Coin coin;
}
