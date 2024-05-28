package com.gp1.gstock.coin.repository;

import com.gp1.gstock.coin.entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<Coin, String> {
}
