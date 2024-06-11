package com.tpi.assignment.service;

import com.tpi.assignment.model.Currency;
import com.tpi.assignment.repository.CurrencyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencyServiceTests {

    @Mock
    private CurrencyRepository currencyRepository;

    @InjectMocks
    private CurrencyService currencyService = new CurrencyServiceImpl();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCurrencies() {
        List<Currency> currencies = Collections.singletonList(new Currency("USD", "US Dollar", 1.0));
        Mockito.when(currencyRepository.findAll()).thenReturn(currencies);

        List<Currency> result = currencyService.getAllCurrencies();
        assertEquals(currencies.size(), result.size());
    }

    // Similar tests for other service methods
}
