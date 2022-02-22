package com.netcracker.currencyconversionservice.currencyconversioncontroller;

import com.netcracker.currencyconversionservice.currencyconversionservice.CurrencyConversion;
import com.netcracker.currencyconversionservice.dto.Currency;
import com.netcracker.currencyconversionservice.dto.ResponsePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-converter")
public class CurrencyConversionController {

    @Autowired
    CurrencyConversion currencyConversion;

    @GetMapping(value = "/from/{from}/to/{to}/quantity/{quantity}")
    public ResponsePojo getExchangeAnswer(@PathVariable("from") String fromCurrency, @PathVariable("to") String toCurrency, @PathVariable("quantity") BigDecimal quantity) {
        Currency currency = currencyConversion.getExchangeRecord(fromCurrency, toCurrency);
        try {
            BigDecimal multiple = currency.getValue();
            return new ResponsePojo(fromCurrency, toCurrency, multiple, quantity, quantity.multiply(multiple));
        } catch (NullPointerException e) {
            return new ResponsePojo(fromCurrency, toCurrency, null, quantity, null);
        }
    }
}
