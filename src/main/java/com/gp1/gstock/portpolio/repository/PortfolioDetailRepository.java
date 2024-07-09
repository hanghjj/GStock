package com.gp1.gstock.portpolio.repository;

import com.gp1.gstock.portpolio.entity.PortfolioDetail;
import com.gp1.gstock.portpolio.entity.PortfolioDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioDetailRepository extends JpaRepository<PortfolioDetail, PortfolioDetailId> {
    List<PortfolioDetail> findByIdPortfolioId(String portfolioId);
}
