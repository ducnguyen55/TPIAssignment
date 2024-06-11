package com.tpi.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoindeskAPIService {

    private static final String COINDESK_API_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";

    private final RestTemplate restTemplate;

    public CoindeskAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getCoindeskData() {
        return restTemplate.getForObject(COINDESK_API_URL, String.class);
    }

    @Scheduled(fixedRate = 3600000) // 3600000 milliseconds = 1 hour
    public void synchronizeExchangeRates() {
        getCoindeskData();
    }
}