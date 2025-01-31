package com.example.priceservice.controller;

import com.example.priceservice.model.Price;
import com.example.priceservice.service.PriceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    /**
     * Endpoint para obtener el precio de un producto en una fecha específica por orden de prioridad.
     */
    @GetMapping
    public ResponseEntity<Price> getPrice(@RequestParam Integer productId,
                                          @RequestParam Integer brandId,
                                          @RequestParam String date) {
        LocalDateTime dateTime = LocalDateTime.parse(date);
        Optional<Price> price = priceService.getApplicablePrice(productId, brandId, dateTime);
        return price.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
