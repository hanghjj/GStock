package com.gp1.gstock.stock.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gp1.gstock.stock.dto.StockDto;
import com.gp1.gstock.stock.dto.StockPriceDto;
import com.gp1.gstock.stock.entity.Stock;

public interface StockService {
    Stock getStock(String srtnCd);
    void saveStock(StockDto stockDto);
    void saveStock(StockPriceDto stockPriceDto);
    void updateStock(String srtnCd) throws Exception;
    void deleteStock(String srtnCd) throws Exception;
    StockDto getStockInfoFromKis(String srtnCd) throws JsonProcessingException;
    StockPriceDto getStockPriceFromKis(String srtnCd) throws JsonProcessingException;
}
