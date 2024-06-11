package com.tpi.assignment.repository;

import com.tpi.assignment.model.Currency;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CurrencyRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Test
    public void testFindByCode() {
        // Given
        Currency currency = new Currency("USD", "US Dollar", 1.0);
        entityManager.persist(currency);
        entityManager.flush();

        // When
        Optional<Currency> found = currencyRepository.findById(currency.getCode());

        // Then
        assertEquals(currency.getCode(), found.get().getCode());
        assertEquals(currency.getName(), found.get().getName());
        assertEquals(currency.getExchangeRate(), found.get().getExchangeRate());
    }

    // Similar tests for other repository methods
}

