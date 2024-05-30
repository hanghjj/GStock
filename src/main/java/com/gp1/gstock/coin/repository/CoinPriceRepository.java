package com.gp1.gstock.coin.repository;

import com.gp1.gstock.coin.entity.CoinPrice;
import com.gp1.gstock.coin.entity.CoinPriceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinPriceRepository extends JpaRepository<CoinPrice, CoinPriceId> {
}
