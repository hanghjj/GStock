package com.gp1.gstock.coin.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gp1.gstock.coin.dto.CoinDto;

public interface CoinService{
    CoinDto getCoin(String ticker) throws JsonProcessingException;
    void saveCoin(CoinDto coin);
}
