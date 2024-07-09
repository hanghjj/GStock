package com.gp1.gstock.portpolio.repository;

import com.gp1.gstock.portpolio.entity.Portfolio;
import com.gp1.gstock.portpolio.entity.PortfolioId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, PortfolioId> {
    List<Portfolio> findByIdUserId(String userId);
}
