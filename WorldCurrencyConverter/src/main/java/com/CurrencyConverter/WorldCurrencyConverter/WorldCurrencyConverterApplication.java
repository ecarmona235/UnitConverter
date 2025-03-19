package com.CurrencyConverter.WorldCurrencyConverter;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorldCurrencyConverterApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(WorldCurrencyConverterApplication.class, args);
		// GetRates.getAllRates();  // make this into conditional which will only run if its been a month since last update
		// set this to only call the above function if current JSON is outdated 
	}

}
