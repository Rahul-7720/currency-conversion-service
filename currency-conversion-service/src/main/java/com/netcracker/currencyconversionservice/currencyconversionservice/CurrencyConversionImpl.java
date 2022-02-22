package com.netcracker.currencyconversionservice.currencyconversionservice;

import com.netcracker.currencyconversionservice.dto.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CurrencyConversionImpl implements CurrencyConversion {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Override
    public Currency getExchangeRecord(String fromCurrency, String toCurrency) {

        return webClientBuilder.build()
                .get()
                .uri("http://CURRENCY-EXCHANGE-SERVICE/currency-exchange/clientCall/from/"+fromCurrency+"/to/"+toCurrency)
                .retrieve()
                .bodyToMono(Currency.class)
                .block();
    }

}









//    @Override
//    public ResponsePojo getExchangeResult(BigDecimal quantity, String fromCurrency, String toCurrency) {
//        BigDecimal exchangeValue=webClientBuilder.build()
//                .get()
//                .uri("http://CURRENCY-EXCHANGE-SERVICE/currency-exchange/from/"+fromCurrency+"/to/"+toCurrency)
//                .retrieve()
//                .bodyToMono(BigDecimal.class)
//                .block();
//        return new ResponsePojo(fromCurrency,toCurrency,exchangeValue,quantity,exchangeValue.multiply(quantity));
//    }



