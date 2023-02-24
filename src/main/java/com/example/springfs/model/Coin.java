package com.example.springfs.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

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
}
