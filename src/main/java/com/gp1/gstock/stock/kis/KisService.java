package com.gp1.gstock.stock.kis;

import com.gp1.gstock.api.ApiAction;
import com.gp1.gstock.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import static com.gp1.gstock.stock.kis.KisConstants.*;

@Service
public class KisService {
    @Autowired
    private ApiAction apiAction;

    public String getStockPrice(String id) {
        JSONObject result = StringUtils.isDigit(id)?getDomesticStockPrice(id):getOverseasStockPrice(id);
        return result.toString();
    }
    public JSONObject getDomesticStockPrice(String id){
        String url = KisConstants.REST_BASE_URL + KisConstants.DOMESTIC_STOCK_PRICE_URL + KisConstants.DOMESTIC_STOCK_PRICE_QUERY + id;
        return apiAction.get(url, KisConstants.DOMESTIC_STOCK_PRICE_KEY);
    }

    public JSONObject getOverseasStockPrice(String id){
        String url = KisConstants.REST_BASE_URL + OVERSEAS_STOCK_PRICE_URL + OVERSEAS_STOCK_PRICE_QUERY + id;
        return apiAction.get(url, OVERSEAS_STOCK_PRICE_KEY);
    }
    public String getStockInfo(String id) {
        String productTypeCode = StringUtils.isDigit(id) ? "300" : "512";
        String url = KisConstants.REST_BASE_URL + TOTAL_STOCK_INFO_URL + "?" + STOCK_INFO_PRODUCT_NO + id + "&" + STOCK_INFO_PRODUCT_TYPE_CODE + productTypeCode;
        JSONObject result = apiAction.get(url, KisConstants.TOTAL_STOCK_INFO_KEY);
        return result.toString();
    }
}
