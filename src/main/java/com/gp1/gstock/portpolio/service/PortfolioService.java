package com.gp1.gstock.portpolio.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gp1.gstock.portpolio.dto.PortfolioDto;
import com.gp1.gstock.portpolio.entity.Portfolio;

import java.util.List;

public interface PortfolioService {
    List<Portfolio> getPortfolioList(String userId);
    List<PortfolioDto> getPortfolioDetailList(String userId, String portfolioId);
    PortfolioDto getLatestPrice(PortfolioDto dto) throws JsonProcessingException;
    void insertPortfolio(PortfolioDto portfolioDto);
    void insertPortfolioDetails(PortfolioDto portfolioDto);
    void deletePortfolio(String userId, String PortfolioId);
}
