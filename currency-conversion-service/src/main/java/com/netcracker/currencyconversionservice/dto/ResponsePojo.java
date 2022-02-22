package com.netcracker.currencyconversionservice.dto;

import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ResponsePojo {
    private String from;
    private String to;
    private BigDecimal multiple;
    private BigDecimal quantity;
    private BigDecimal totalAmount;
}
