package com.gmarket.stock.repository;

import com.gmarket.stock.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : ykim14
 * @fileName : StockRepository
 * @since : 2024-09-23
 */
public interface StockRepository extends JpaRepository<Stock, Long> {
}
