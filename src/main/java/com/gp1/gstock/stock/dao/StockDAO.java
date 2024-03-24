package com.gp1.gstock.stock.dao;

import com.gp1.gstock.stock.entity.Stock;
import com.gp1.gstock.stock.entity.StockPrice;

public interface StockDAO {

    void insertStock(Stock Stock);
    void insertStockPrice(StockPrice stockPrice);
    Stock selectStock(String bseDt, String srtnCd);
    void updateStock(String bseDt, String srtnCd) throws Exception;
    void deleteStock(String bseDt, String srtnCd) throws Exception;
}
