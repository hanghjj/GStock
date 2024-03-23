package com.gp1.gstock.data.repository;

import com.gp1.gstock.data.entity.StockId;
import com.gp1.gstock.data.entity.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockPriceRepository extends JpaRepository<StockPrice, StockId> {
}
