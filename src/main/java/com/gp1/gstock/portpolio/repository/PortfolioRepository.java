package com.gp1.gstock.portpolio.repository;

import com.gp1.gstock.portpolio.entity.Portfolio;
import com.gp1.gstock.portpolio.entity.PortfolioId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, PortfolioId> {
}
