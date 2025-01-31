package com.example.priceservice;

import com.example.priceservice.model.Price;
import com.example.priceservice.repository.PriceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class PriceServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PriceServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(PriceRepository priceRepository) {
        return args -> {
            priceRepository.saveAll(List.of(
                    new Price(1, LocalDateTime.parse("2020-06-14T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), 1, 35455, 0, new BigDecimal("35.50"), "EUR"),
                    new Price(1, LocalDateTime.parse("2020-06-14T15:00:00"), LocalDateTime.parse("2020-06-14T18:30:00"), 2, 35455, 1, new BigDecimal("25.45"), "EUR"),
                    new Price(1, LocalDateTime.parse("2020-06-15T00:00:00"), LocalDateTime.parse("2020-06-15T11:00:00"), 3, 35455, 1, new BigDecimal("30.50"), "EUR"),
                    new Price(1, LocalDateTime.parse("2020-06-15T16:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), 4, 35455, 1, new BigDecimal("38.95"), "EUR")
            ));
        };
    }
}
