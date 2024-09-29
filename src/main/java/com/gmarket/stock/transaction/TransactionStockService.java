package com.gmarket.stock.transaction;

import com.gmarket.stock.service.StockService;

/**
 * @author : ykim14
 * @fileName : TransactionStockService
 * @since : 2024-09-29
 */
public class TransactionStockService {
    private StockService stockService;

    public TransactionStockService(StockService stockService) {
        this.stockService = stockService;
    }

    public void decrease(Long id, Long quantity) {
        startTransaction();

        stockService.decrease(id, quantity);

        endTransaction();
    }

    private void startTransaction() {
        System.out.println("Transaction Start");
    }

    private void endTransaction() {
        System.out.println("Commit");
    }
}
