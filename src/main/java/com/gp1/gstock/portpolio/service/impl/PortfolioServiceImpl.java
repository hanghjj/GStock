package com.gp1.gstock.portpolio.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gp1.gstock.common.Exception.CustomException;
import com.gp1.gstock.common.utils.DateTimeUtils;
import com.gp1.gstock.common.utils.StringUtils;
import com.gp1.gstock.portpolio.dto.PortfolioDto;
import com.gp1.gstock.portpolio.entity.Portfolio;
import com.gp1.gstock.portpolio.entity.PortfolioDetail;
import com.gp1.gstock.portpolio.entity.PortfolioDetailId;
import com.gp1.gstock.portpolio.entity.PortfolioId;
import com.gp1.gstock.portpolio.repository.PortfolioDetailRepository;
import com.gp1.gstock.portpolio.repository.PortfolioRepository;
import com.gp1.gstock.portpolio.service.PortfolioService;
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
    private final PortfolioRepository portfolioRepository;
    private final PortfolioDetailRepository portfolioDetailRepository;

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
        for (PortfolioDto dto : resultList) {
            try {
                dto = this.getLatestPrice(dto);
            } catch (JsonProcessingException e) {
                throw new CustomException("portfolio.update.fail");
            }
        }
        // return updated detailList
        return resultList;
    }

    @Override
    public PortfolioDto getLatestPrice(PortfolioDto dto) throws JsonProcessingException {
        String asstSeCd = dto.getAsstSeCd();
        String ticker = dto.getTicker();
        switch (asstSeCd) {
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
        PortfolioId portfolioId = new PortfolioId(portfolioDto.getUserId(), portfolioDto.getPortfolioId());
        Portfolio portfolio = new Portfolio();
        portfolio.setId(portfolioId);
        portfolioRepository.save(portfolio);
        if(StringUtils.isEmpty(portfolioDto.getTicker())) this.insertPortfolioDetails(portfolioDto);
    }

    @Override
    public void insertPortfolioDetails(PortfolioDto dto) {
        PortfolioDetailId portfolioDetailId = new PortfolioDetailId(dto.getPortfolioId(), dto.getTicker());
        PortfolioDetail detail = new PortfolioDetail();
        detail.setPortfolioDetailId(portfolioDetailId);
        BeanUtils.copyProperties(dto, detail);
        portfolioDetailRepository.save(detail);
    }

    @Override
    public void deletePortfolio(String userId, String PortfolioId) {

    }
}
