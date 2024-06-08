package com.gp1.gstock.portpolio.service.impl;

import com.gp1.gstock.portpolio.dto.PortfolioDto;
import com.gp1.gstock.portpolio.entity.Portfolio;
import com.gp1.gstock.portpolio.service.PortfolioService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.gp1.gstock.common.constants.BizConstants.*;

@Service
@Slf4j
@AllArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {
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
        resultList.forEach(this::getLatestPrice);
        // return updated detailList
        return resultList;
    }

    @Override
    public PortfolioDto getLatestPrice(PortfolioDto dto) {
        String assetSeCd = dto.getAssetSeCd();
        switch (assetSeCd){
            case ASSET_STOCK:
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
