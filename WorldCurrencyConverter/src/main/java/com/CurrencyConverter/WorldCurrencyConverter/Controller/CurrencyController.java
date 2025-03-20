package com.CurrencyConverter.WorldCurrencyConverter.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CurrencyConverter.WorldCurrencyConverter.Service.CurrencyService;

@RestController
public class CurrencyController {
    private CurrencyService currencyService;

    public CurrencyController() {
        this.currencyService = new CurrencyService();
    }

    @GetMapping("/")
    public double ConvertTotal(@RequestParam String source, @RequestParam String target, @RequestParam String total) {
        double retTotal;
        source = source.toUpperCase();
        target = target.toUpperCase();
        
        if (!currencyService.hasSymbol((source.toUpperCase() + "/" + target))) {
            System.err.println("Currency not found");
            return 0.00;
        }
        try {
            retTotal = currencyService.convertCurrency((source + "/" + target), Double.parseDouble(total));
        } catch (Exception e) {
            System.err.println(e);
            retTotal = 0.0;
        }

        return retTotal;
    }

}
