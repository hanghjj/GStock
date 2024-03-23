package com.gp1.gstock.data.repository;

import com.gp1.gstock.data.entity.Stock;
import com.gp1.gstock.data.entity.StockId;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StockRepository extends JpaRepository<Stock, StockId> {


}
