package com.gp1.gstock.stock.kis;

import com.gp1.gstock.api.ApiAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class KisService {
    @Autowired
    private ApiAction apiAction;
    public String getDomesticStockPrice(String id){
        String url = KisConstants.REST_BASE_URL + KisConstants.DOMESTIC_STOCK_URL + KisConstants.DOMESTIC_STOCK_PRICE_QUERY + id;
        JSONObject result = apiAction.get(url, KisConstants.DOMESTIC_STOCK_PRICE_KEY);
        return result.toString();
    }

    public String getDomesticStockInfo(String id){
        String url = KisConstants.REST_BASE_URL + KisConstants.DOMESTIC_STOCK_INFO_URL + KisConstants.DOMESTIC_STOCK_INFO_QUERY + id;
        JSONObject result = apiAction.get(url, KisConstants.DOMESTIC_STOCK_INFO_KEY);
        return result.toString();
    }
}
