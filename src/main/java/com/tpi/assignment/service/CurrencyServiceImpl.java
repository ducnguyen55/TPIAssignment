package com.tpi.assignment.service;

import com.tpi.assignment.model.Currency;
import com.tpi.assignment.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    @Override
    public Currency getCurrencyByCode(String code) {
        return currencyRepository.findById(code).orElse(null);
    }

    @Override
    public Currency createCurrency(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    public Currency updateCurrency(String code, Currency currency) {
        if (currencyRepository.existsById(code)) {
            currency.setCode(code);
            return currencyRepository.save(currency);
        }
        return null;
    }

    @Override
    public void deleteCurrency(String code) {
        currencyRepository.deleteById(code);
    }
}
