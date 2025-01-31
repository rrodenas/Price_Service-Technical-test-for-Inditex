package com.example.priceservice;

import com.example.priceservice.model.Price;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceServiceApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "/prices?productId=35455&brandId=1&date=";

    @Test
    void test1() {
        ResponseEntity<Price> response = restTemplate.getForEntity(BASE_URL + "2020-06-14T10:00:00", Price.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void test2() {
        ResponseEntity<Price> response = restTemplate.getForEntity(BASE_URL + "2020-06-14T16:00:00", Price.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void test3() {
        ResponseEntity<Price> response = restTemplate.getForEntity(BASE_URL + "2020-06-14T21:00:00", Price.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
