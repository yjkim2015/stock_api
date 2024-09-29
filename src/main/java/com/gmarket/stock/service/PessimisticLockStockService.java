package com.gmarket.stock.service;

import com.gmarket.stock.domain.Stock;
import com.gmarket.stock.repository.StockRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * @author : ykim14
 * @fileName : PerssimisticLockStockService
 * @since : 2024-09-29
 */
@Service
public class PessimisticLockStockService {

    private final StockRepository stockRepository;

    public PessimisticLockStockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    public void decrease(Long id, Long quantity) {
        Stock stock = stockRepository.findByIdWithPessimisticLoc(id);
        stock.decrease(quantity);

        stockRepository.save(stock);
    }
}
