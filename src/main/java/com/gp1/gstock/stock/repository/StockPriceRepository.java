package com.gp1.gstock.stock.repository;

import com.gp1.gstock.stock.entity.StockId;
import com.gp1.gstock.stock.entity.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockPriceRepository extends JpaRepository<StockPrice, StockId> {
}
