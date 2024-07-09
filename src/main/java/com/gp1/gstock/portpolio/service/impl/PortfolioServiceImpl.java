package com.gp1.gstock.portpolio.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gp1.gstock.coin.dto.CoinDto;
import com.gp1.gstock.coin.service.CoinService;
import com.gp1.gstock.common.Exception.CustomException;
import com.gp1.gstock.common.utils.StringUtils;
import com.gp1.gstock.portpolio.dto.PortfolioDto;
import com.gp1.gstock.portpolio.entity.Portfolio;
import com.gp1.gstock.portpolio.entity.PortfolioDetail;
import com.gp1.gstock.portpolio.entity.PortfolioDetailId;
import com.gp1.gstock.portpolio.entity.PortfolioId;
import com.gp1.gstock.portpolio.repository.PortfolioDetailRepository;
import com.gp1.gstock.portpolio.repository.PortfolioRepository;
import com.gp1.gstock.portpolio.service.PortfolioService;
import com.gp1.gstock.stock.dto.StockDto;
import com.gp1.gstock.stock.dto.StockPriceDto;
import com.gp1.gstock.stock.service.StockService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.gp1.gstock.common.constants.BizConstants.*;

@Service
@Slf4j
@AllArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {
    private final StockService stockService;
    private final CoinService coinService;
    private final PortfolioRepository portfolioRepository;
    private final PortfolioDetailRepository portfolioDetailRepository;

    @Override
    public List<PortfolioDto> getPortfolioList(String userId) {
        // get portfolioId per user
        List<Portfolio> entityList = portfolioRepository.findByIdUserId(userId);
        if(entityList.size()==0) return Collections.emptyList();
        return entityList.stream()
                .map(this::convertPortfolioToDto)
                .toList();
    }

    @Override
    public List<PortfolioDto> getPortfolioDetailList(String portfolioId) {
        // getPortFolioDetailList
        List<PortfolioDetail> entityList = portfolioDetailRepository.findByIdPortfolioId(portfolioId);
        if (entityList.size() == 0) return Collections.emptyList();
        List<PortfolioDto> resultList = entityList.stream().map(this::convertPortfolioToDto).toList();
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
        Double qty = dto.getQty();
        double pcsPce = new BigDecimal(dto.getAvgPcsPce() * qty).doubleValue(); //매수평균가 * 수량 = 매수금액
        switch (asstSeCd) {
            case ASSET_STOCK:
                StockDto stockDto = stockService.getStockInfoFromKis(ticker);
                StockPriceDto stockPriceDto = stockService.getStockPriceFromKis(ticker);
                stockService.saveStock(stockDto);
                stockService.saveStock(stockPriceDto);
                double mktPce = new BigDecimal(stockPriceDto.getStkPrpr() * qty).doubleValue();//주식현재가 * 수량 = 평가금액
                dto.setMktPce(mktPce);
                dto.setMktPnl(mktPce - pcsPce);
                break;
            case ASSET_COIN:
                CoinDto coinDto = coinService.getCoin(ticker);
                mktPce = new BigDecimal(coinDto.getPrpr() * qty).doubleValue();//코인현재가 * 수량 = 평가금액
                dto.setMktPce(mktPce);
                dto.setMktPnl(mktPce - pcsPce);
                break;
            case ASSET_USD:
            case ASSET_KRW:
                dto.setMktPce(pcsPce);
                dto.setMktPnl(0d);
                break;
        }
        return dto;
    }

    @Override
    public void insertPortfolio(PortfolioDto portfolioDto) {
        PortfolioId portfolioId = new PortfolioId(portfolioDto.getUserId(), portfolioDto.getPortfolioId());
        Portfolio portfolio = new Portfolio();
        portfolio.setId(portfolioId);
        portfolioRepository.save(portfolio);
        if (!StringUtils.isEmpty(portfolioDto.getTicker())) this.insertPortfolioDetails(portfolioDto);
    }

    @Override
    public void insertPortfolioDetails(PortfolioDto dto) {
        PortfolioDetailId portfolioDetailId = new PortfolioDetailId(dto.getPortfolioId(), dto.getTicker());
        PortfolioDetail detail = new PortfolioDetail();
        detail.setId(portfolioDetailId);
        BeanUtils.copyProperties(dto, detail);
        portfolioDetailRepository.save(detail);
    }

    @Override
    public void deletePortfolio(String userId, String PortfolioId) {

    }

    @Override
    public PortfolioDto convertPortfolioToDto(Portfolio portfolio) {
        PortfolioDto portfolioDto = new PortfolioDto();
        BeanUtils.copyProperties(portfolio, portfolioDto);
        portfolioDto.setUserId(portfolio.getId().getUserId());
        portfolioDto.setPortfolioId(portfolio.getId().getPortfolioId());
        return portfolioDto;
    }

    @Override
    public PortfolioDto convertPortfolioToDto(PortfolioDetail portfolioDetail) {
        PortfolioDto portfolioDto = new PortfolioDto();
        BeanUtils.copyProperties(portfolioDetail, portfolioDto);
        portfolioDto.setPortfolioId(portfolioDetail.getId().getPortfolioId());
        portfolioDto.setTicker(portfolioDetail.getId().getTicker());
        return portfolioDto;
    }
}
