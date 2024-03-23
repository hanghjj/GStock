package com.gp1.gstock.service;

import com.gp1.gstock.data.dto.StockDto;
import com.gp1.gstock.data.dto.StockPriceDto;
import com.gp1.gstock.data.entity.Stock;

public interface StockService {
    Stock getStock(String bseDt, String srtnCd);
    void saveStock(StockDto stockDto);
    void saveStock(StockPriceDto stockPriceDto);
    void updateStock(String bseDt, String srtnCd) throws Exception;
    void deleteStock(String bseDt, String srtnCd) throws Exception;
}
