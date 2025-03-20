package com.CurrencyConverter.WorldCurrencyConverter.Service;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.text.ParseException;
import java.util.HashMap;

public class RatesJsonTraversal {
    public static long daysSinceLastUpdate() throws IOException, ParseException {
        /*
         * Function returns how many days its been since the last time the rates.json
         * file was update.
         */
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(
                new File("/home/elvin/Documents/development/UnitConverter/WorldCurrencyConverter/rates.json"));
        String date = jsonNode.at("/info/server_time").asText();
        LocalDate fileDate = LocalDate.parse(date.substring(0, 10)); // date on JSON file as substring for yyyy-mm-dd
        LocalDate currentDate = LocalDate.now();

        return ChronoUnit.DAYS.between(fileDate, currentDate);

    }

    public static HashMap<String, Double> fillRatesHash(HashMap<String, Double> ratesMap) throws IOException {
        /*
         * Function used to fill hashmap
         */
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(
                new File("/home/elvin/Documents/development/UnitConverter/WorldCurrencyConverter/rates.json"));
        JsonNode rate = jsonNode.get("response");
        for (JsonNode objNode : rate) {// iterator for response array
            // key: Symbol (e.g EUR/USD), Value: currency (as double)
            ratesMap.put(objNode.get("s").asText(), objNode.get("c").asDouble());

        }
        return ratesMap;

    }

}
