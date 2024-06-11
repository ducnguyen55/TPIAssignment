package com.tpi.assignment.factory;

import com.tpi.assignment.model.Currency;

public interface CurrencyFactory {
    Currency createCurrency(String code, String name, double exchangeRate);
}