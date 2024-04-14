package com.gp1.gstock.stock.repository;

import com.gp1.gstock.stock.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StockRepository extends JpaRepository<Stock, String> {


}
