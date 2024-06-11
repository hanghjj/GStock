package com.gp1.gstock.portpolio.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gp1.gstock.common.Exception.CustomException;
import com.gp1.gstock.portpolio.dto.PortfolioDto;
import com.gp1.gstock.portpolio.entity.Portfolio;
import com.gp1.gstock.portpolio.service.PortfolioService;
import com.gp1.gstock.stock.dto.StockDto;
import com.gp1.gstock.stock.dto.StockPriceDto;
import com.gp1.gstock.stock.service.StockService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.gp1.gstock.common.constants.BizConstants.*;

@Service
@Slf4j
@AllArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {
    private final StockService stockService;
    @Override
    public List<Portfolio> getPortfolioList(String userId) {
        // get portfolioId per user
        return null;
    }

    @Override
    public List<PortfolioDto> getPortfolioDetailList(String userId, String portfolioId) {
        // getPortFolioDetailList
        List<PortfolioDto> resultList = new ArrayList<>();
        //resultList = DAO ~~
        // update All asset prices
        for(PortfolioDto dto : resultList){
            try{
                dto = this.getLatestPrice(dto);
            }catch (JsonProcessingException e){
                throw new CustomException("portfolio.update.fail");
            }
        }
        // return updated detailList
        return resultList;
    }

    @Override
    public PortfolioDto getLatestPrice(PortfolioDto dto) throws JsonProcessingException {
        String assetSeCd = dto.getAssetSeCd();
        String ticker = dto.getTicker();
        switch (assetSeCd){
            case ASSET_STOCK:
                stockService.saveStock(stockService.getStockInfoFromKis(ticker));
                stockService.saveStock(stockService.getStockPriceFromKis(ticker));
                break;
            case ASSET_COIN:
                break;
            case ASSET_USD:
            case ASSET_KRW:
                //do nothing
                break;
        }
        return new PortfolioDto();
    }

    @Override
    public void insertPortfolio(PortfolioDto portfolioDto) {

    }

    @Override
    public void updatePortfolio(PortfolioDto portfolioDto) {

    }

    @Override
    public void deletePortfolio(String userId, String PortfolioId) {

    }
}
