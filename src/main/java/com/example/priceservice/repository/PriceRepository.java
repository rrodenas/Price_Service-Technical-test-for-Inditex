package com.example.priceservice.repository;

import com.example.priceservice.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    /**
     * Obtiene el precio aplicable con la mayor prioridad para un producto y marca en un rango de fechas.
     */
    List<Price> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            Integer productId, Integer brandId, LocalDateTime startDate, LocalDateTime endDate);
}
