package com.gp1.gstock.stock.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gp1.gstock.api.obj.CTPF1002R;
import com.gp1.gstock.api.obj.CustomObjectMapper;
import com.gp1.gstock.api.obj.FHKST01010100;
import com.gp1.gstock.stock.dto.KisStockPrice;
import com.gp1.gstock.stock.dto.StockDto;
import com.gp1.gstock.stock.dto.StockPriceDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ObjectMappingService {

    private final CustomObjectMapper mapper;

    public StockPriceDto ConvertFHKST01010100ToStockPriceDto(String jsonString, String srtnCd) throws JsonProcessingException {
        //convert json to apiObj
        FHKST01010100 fhkst01010100 = mapper.readValue(jsonString, FHKST01010100.class);
        // apiObj to KisStockPrice
        KisStockPrice convert = fhkst01010100.convert(srtnCd);
        //convert KisStockPrice to StockPrice
        return convert.convert();
    }
    public KisStockPrice ConvertFHKST01010100ToKisStockPrice(String jsonString, String srtnCd) throws JsonProcessingException {
        //convert json to apiObj
        FHKST01010100 fhkst01010100 = mapper.readValue(jsonString, FHKST01010100.class);
        // apiObj to KisStockPrice
        return fhkst01010100.convert(srtnCd);
    }
    public StockDto ConvertCTPF1002RToStockDto(String jsonString) throws JsonProcessingException {
        //convert json to apiObj
        CTPF1002R ctpf1002R = mapper.readValue(jsonString, CTPF1002R.class);
        //convert apiObj to StockDto
        return ctpf1002R.convert();
    }
}
