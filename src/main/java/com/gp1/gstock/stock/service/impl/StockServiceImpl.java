package com.gp1.gstock.stock.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gp1.gstock.common.Exception.CustomException;
import com.gp1.gstock.common.service.impl.ObjectMappingService;
import com.gp1.gstock.common.utils.StringUtils;
import com.gp1.gstock.stock.dao.StockDAO;
import com.gp1.gstock.stock.dto.StockDto;
import com.gp1.gstock.stock.dto.StockPriceDto;
import com.gp1.gstock.stock.entity.Stock;
import com.gp1.gstock.stock.entity.StockPrice;
import com.gp1.gstock.stock.kis.KisService;
import com.gp1.gstock.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockServiceImpl implements StockService {

    private final StockDAO stockDAO;
    private final KisService kisService;
    private final ObjectMappingService objectMappingService;

    @Override
    public Stock getStock(String srtnCd) {
        return stockDAO.selectStock(srtnCd);
    }

    @Override
    public void saveStock(StockDto stockDto) {
        stockDAO.insertStock(new Stock(stockDto));
    }

    @Override
    public void saveStock(StockPriceDto StockPriceDto) {
        stockDAO.insertStockPrice(new StockPrice(StockPriceDto));
    }

    @Override
    public void updateStock(String srtnCd) throws Exception {
        stockDAO.updateStock(srtnCd);
    }

    @Override
    public void deleteStock(String srtnCd) throws Exception {
        stockDAO.deleteStock(srtnCd);
    }

    @Override
    public StockDto getStockInfoFromKis(String srtnCd) throws JsonProcessingException, CustomException {
        String stockInfoJson = kisService.getStockInfo(srtnCd);
        JSONObject output1 = null;
        try {
            output1 = new JSONObject(stockInfoJson).getJSONObject("output");
        } catch (JSONException e) {
            throw new CustomException("stock.search.fail");
        }
        //convert Json to StockDto
        StockDto stockDto = objectMappingService.ConvertCTPF1604RToStockDto(output1.toString());
        log.info("주식 정보 조회 " + output1.toString());
        if (Optional.ofNullable(stockDto.getItmNm()).orElse("").length() < 1) {
            throw new CustomException("stock.search.fail");
        }
        return stockDto;
    }

    @Override
    public StockPriceDto getStockPriceFromKis(String srtnCd) throws JsonProcessingException {
        boolean isDomestic = StringUtils.isDigit(srtnCd);
        String stockPriceJson = kisService.getStockPrice(srtnCd);
        JSONObject output2 = null;
        try {
            output2 = new JSONObject(stockPriceJson).getJSONObject("output");
        } catch (JSONException e) {
            throw new CustomException("stock.search.fail");
        }
        //convert Json to StockPriceDto
        StockPriceDto stockPriceDto = isDomestic?
                objectMappingService.ConvertFHKST01010100ToStockPriceDto(output2.toString(), srtnCd):
                objectMappingService.ConvertHHDFS00000300ToStockPriceDto(output2.toString(), srtnCd);
        if(stockPriceDto.getStkPrpr()==0){
            throw new CustomException("stock.unavailable.error", List.of(stockPriceDto.getSrtnCd()));
        }
        return stockPriceDto;
    }
}
