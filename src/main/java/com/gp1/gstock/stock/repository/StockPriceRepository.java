package com.gp1.gstock.stock.repository;

import com.gp1.gstock.stock.entity.StockPrice;
import com.gp1.gstock.stock.entity.StockPriceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockPriceRepository extends JpaRepository<StockPrice, StockPriceId> {
}
