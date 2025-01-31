package com.example.priceservice.service;

import com.example.priceservice.model.Price;
import com.example.priceservice.repository.PriceRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    /**
     * Obtiene el precio aplicable con mayor prioridad para un producto, marca y fecha dada.
     */
    public Optional<Price> getApplicablePrice(Integer productId, Integer brandId, LocalDateTime date) {
        return priceRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(productId, brandId, date, date)
                .stream().findFirst(); // Devuelve solo el precio con mayor prioridad
    }
}
