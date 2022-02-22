package com.netcracker.currencyconversionservice.currencyconversionservice;

import com.netcracker.currencyconversionservice.dto.Currency;

public interface CurrencyConversion {
     Currency getExchangeRecord(String fromCurrency,String toCurrency);
}
