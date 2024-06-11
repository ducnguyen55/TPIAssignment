package com.tpi.assignment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tpi.assignment.model.Currency;
import com.tpi.assignment.service.CurrencyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CurrencyService currencyService;

    @Test
    public void testGetAllCurrencies() throws Exception {
        List<Currency> currencies = Collections.singletonList(new Currency("USD", "US Dollar", 1.0));

        // Mock the service method
        Mockito.when(currencyService.getAllCurrencies()).thenReturn(currencies);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/currencies"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(currencies)));
    }

    // Similar tests for other controller methods
}
