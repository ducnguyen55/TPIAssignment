package com.tpi.assignment.factory;

import com.tpi.assignment.model.Currency;
import org.springframework.stereotype.Component;

@Component
public class DefaultCurrencyFactory implements CurrencyFactory {

    @Override
    public Currency createCurrency(String code, String name, double exchangeRate) {
        return new Currency(code, name, exchangeRate);
    }
}
