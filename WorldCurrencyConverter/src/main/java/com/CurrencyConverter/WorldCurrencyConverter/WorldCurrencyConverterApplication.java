package com.CurrencyConverter.WorldCurrencyConverter;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class WorldCurrencyConverterApplication {

	public static void main(String[] args) throws IOException, ParseException {
		SpringApplication.run(WorldCurrencyConverterApplication.class, args);
		
	}

}
