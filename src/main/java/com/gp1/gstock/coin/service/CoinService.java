package com.gp1.gstock.coin.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gp1.gstock.coin.dto.CoinDto;
import com.gp1.gstock.coin.entity.Coin;
import com.gp1.gstock.coin.entity.CoinPrice;

public interface CoinService{
    CoinDto getCoin(String ticker) throws JsonProcessingException;
    void saveCoin(Coin coin);
    void saveCoin(CoinPrice coinPrice);
}
