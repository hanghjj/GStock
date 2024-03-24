package com.gp1.gstock.stock.service.impl;

import com.gp1.gstock.common.aop.AopService;
import com.gp1.gstock.stock.dao.StockDAO;
import com.gp1.gstock.stock.dto.StockDto;
import com.gp1.gstock.stock.dto.StockPriceDto;
import com.gp1.gstock.stock.entity.Stock;
import com.gp1.gstock.stock.entity.StockPrice;
import com.gp1.gstock.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockServiceImpl extends AopService implements StockService {

    private final StockDAO stockDAO;

    @Override
    public Stock getStock(String bseDt, String srtnCd){
        return stockDAO.selectStock(bseDt,srtnCd);
    }
    @Override
    public void saveStock(StockDto stockDto){
        stockDAO.insertStock(new Stock(stockDto));
    }

    @Override
    public void saveStock(StockPriceDto StockPriceDto){
        stockDAO.insertStockPrice(new StockPrice(StockPriceDto));
    }
    @Override
    public void updateStock(String bseDt, String srtnCd) throws Exception{
        stockDAO.updateStock(bseDt,srtnCd);
    }
    @Override
    public void deleteStock(String bseDt, String srtnCd) throws Exception{
        stockDAO.deleteStock(bseDt,srtnCd);
    }
}
