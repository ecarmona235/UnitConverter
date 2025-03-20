package com.CurrencyConverter.WorldCurrencyConverter.Service;

import java.util.HashMap;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
    private HashMap<String, Double> ratesMap;

    public CurrencyService(){
        ratesMap = new HashMap<String, Double>();
        populateMap();
    }


    public void populateMap(){
        try {
            if (RatesJsonTraversal.daysSinceLastUpdate() > 30) {
            GetRates.getAllRates();
            // will only run if its been a month since last update
            // would be changed based on which subscription you have on https://fcsapi.com/
            // can be less if you have more credits and want it more frequently updated
            }
            ratesMap = RatesJsonTraversal.fillRatesHash(ratesMap);
            
        } catch (Exception e) {
            System.err.println(e);
        }
        
        
    }
    public double getCurrency(String symbols){
        /*Function gets currency given the correct symbol, returns a double if found and null if not */
        return ratesMap.get(symbols);
    }

    public double convertCurrency(String symbols, Double total){
        return getCurrency(symbols) * total;

    }

    public boolean hasSymbol(String symbol){
        return ratesMap.containsKey(symbol);

    }

}
