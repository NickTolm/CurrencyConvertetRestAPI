package com.example.currencyconvertetrestapi.model;

import lombok.Data;

import java.util.List;

@Data
public class Response {

    private String status;
    private String message;
    private List<String> data;
}
