package com.CurrencyConverter.WorldCurrencyConverter;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorldCurrencyConverterApplication {

	public static void main(String[] args) throws IOException, ParseException {
		SpringApplication.run(WorldCurrencyConverterApplication.class, args);
		if (RatesRetrieval.daysSinceLastUpdate() > 30) {
			GetRates.getAllRates();
			// will only run if its been a month since last update
			// would be changed based on which subscription you have on https://fcsapi.com/
			// can be less if you have more credits
		}
	}

}
