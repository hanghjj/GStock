package com.gp1.gstock.kis;

import com.gp1.gstock.api.ApiAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import static com.gp1.gstock.kis.KisConstants.*;

@Service
public class KisService {
    @Autowired
    private ApiAction apiAction;
    public String getDomesticStockPrice(String id){
        String url = REST_BASE_URL + DOMESTIC_STOCK_URL + DOMESTIC_STOCK_PRICE_QUERY + id;
        JSONObject result = apiAction.get(url, DOMESTIC_STOCK_PRICE_KEY);
        return result.toString();
    }

    public String getDomesticStockInfo(String id){
        String url = REST_BASE_URL + DOMESTIC_STOCK_INFO_URL + DOMESTIC_STOCK_INFO_QUERY + id;
        JSONObject result = apiAction.get(url, DOMESTIC_STOCK_INFO_KEY);
        return result.toString();
    }
}
