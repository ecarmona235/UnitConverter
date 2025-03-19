package com.CurrencyConverter.WorldCurrencyConverter;

import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.text.ParseException;

public class RatesRetrieval {
    public static long daysSinceLastUpdate() throws IOException, ParseException {
        /*
         * Function returns how many days its been since the last time the rates.json file was update. 
         */
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(
                new File("/home/elvin/Documents/development/UnitConverter/WorldCurrencyConverter/rates.json"));
        String date = jsonNode.at("/info/server_time").asText();
        LocalDate fileDate = LocalDate.parse(date.substring(0, 10)); // date on JSON file as substring for yyyy-mm-dd
        LocalDate currentDate = LocalDate.now();

        return ChronoUnit.DAYS.between(fileDate, currentDate);

    }

    public static void getCurrencyRate(String BaseCountry, String EndCountry) throws IOException {
        /*
         * TODO: create function which returns the currency rate to use for conversion,
         * given the two base countries
         * must retrieve symbol == BaseCountry/EndCountry
         * then return "c" for matching symbol
         */
    }

}
