package com.CurrencyConverter.WorldCurrencyConverter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class HttpRequestTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void EUR_USD_BaseTest() {
        assertThat(this.restTemplate.getForObject("/?target=EUR&source=USD&total=200",
                Double.class)).isEqualTo(182.824);
    }

    @Test
    void BadTarget() {
        assertThat(this.restTemplate.getForObject("/?target=ERU&source=USD&total=200",
                Double.class)).isEqualTo(0.00);
    }

    @Test
    void NotCapitalized() {
        assertThat(this.restTemplate.getForObject("/?target=eur&source=USD&total=200",
                Double.class)).isEqualTo(182.824);
    }

    @Test
    void WithDouble() {
        assertThat(this.restTemplate.getForObject("/?target=eur&source=USD&total=200.15",
                Double.class)).isEqualTo(182.96111800000003);
    }

}
