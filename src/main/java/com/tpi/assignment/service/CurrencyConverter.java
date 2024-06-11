package com.tpi.assignment.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyConverter {

    // Singleton instance
    private static CurrencyConverter instance;

    private CurrencyConverter() {
        // Private constructor to prevent instantiation
    }

    public static synchronized CurrencyConverter getInstance() {
        if (instance == null) {
            instance = new CurrencyConverter();
        }
        return instance;
    }

    // Other methods for currency conversion
}
