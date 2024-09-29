package com.gmarket.stock.service;

import com.gmarket.stock.domain.Stock;
import com.gmarket.stock.repository.StockRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * @author : ykim14
 * @fileName : StockService
 * @since : 2024-09-23
 */

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    public synchronized void decrease(Long id, Long quantity) {
        // Stock 조회

        Stock stock = stockRepository.findById(id).orElseThrow();
        // 재고를 감소

        stock.decrease(quantity);

        // 갱신된 값을 저장한다.
        stockRepository.saveAndFlush(stock);
    }
}
