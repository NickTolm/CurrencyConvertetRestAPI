package com.example.currencyconvertetrestapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("application")
@AllArgsConstructor
public class SimpleController {

    private final RestTemplate restTemplate;
    private final String keyApi = "&key=a5762aa04d90dc7136ab92368f19d2d9";

    // http://localhost:8080/application/getExchangeRate?firstCurrency=USDRUB&secondCurrency=EURRUB
    @GetMapping("/getExchangeRate")
    public String getExchangeRate(@RequestParam String firstCurrency, @RequestParam String secondCurrency) {
        ResponseEntity<String> response = restTemplate.
                getForEntity("https://currate.ru/api/?get=rates&pairs=" + firstCurrency + "," + secondCurrency + keyApi, String.class);
        return response.getBody();
    }

    // http://localhost:8080/application/getCurrencyList
    @GetMapping("/getCurrencyList")
    public String getCurrencyList() {
        ResponseEntity<String> response = restTemplate.
                getForEntity("https://currate.ru/api/?get=currency_list" + keyApi, String.class);
        return response.getBody();
    }



}
