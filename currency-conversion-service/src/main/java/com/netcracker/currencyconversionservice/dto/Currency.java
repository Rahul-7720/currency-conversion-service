package com.netcracker.currencyconversionservice.dto;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Currency {

    private int id;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal value;

}
