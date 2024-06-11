package com.tpi.assignment.service;

import com.tpi.assignment.model.Currency;

import java.util.List;

public interface CurrencyService {
    List<Currency> getAllCurrencies();
    Currency getCurrencyByCode(String code);
    Currency createCurrency(Currency currency);
    Currency updateCurrency(String code, Currency currency);
    void deleteCurrency(String code);
}