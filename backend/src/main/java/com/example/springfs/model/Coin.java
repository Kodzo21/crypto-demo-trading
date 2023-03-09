package com.example.springfs.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Coin {

    @Id
    private String id;
    private String symbol;
    private String name;
    private String image;

    @OneToMany(mappedBy = "coin",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CoinPrice> coinPrices;
}
