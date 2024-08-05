package com.gp1.gstock.stock.kis;

import com.gp1.gstock.api.ApiAction;
import com.gp1.gstock.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONObject;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.gp1.gstock.common.constants.BizConstants.DOMESTIC;
import static com.gp1.gstock.common.constants.BizConstants.NASDAQ;
import static com.gp1.gstock.stock.kis.KisConstants.*;

@Service
public class KisService {
    @Autowired
    private ApiAction apiAction;

    public String getStockPrice(String id, String excd) {
        JSONObject result = StringUtils.isDigit(id)?getDomesticStockPrice(id):getOverseasStockPrice(id,excd);
        return result.toString();
    }
    public JSONObject getDomesticStockPrice(String id){
        String url = REST_BASE_URL + DOMESTIC_STOCK_PRICE_URL + DOMESTIC_STOCK_PRICE_QUERY + id;
        return apiAction.get(url, KisConstants.DOMESTIC_STOCK_PRICE_KEY);
    }

    public JSONObject getOverseasStockPrice(String id, String excd){
        String url = REST_BASE_URL + OVERSEAS_STOCK_PRICE_URL + "?auth=&excd="+excd+"&symb=" + id;
        return apiAction.get(url, OVERSEAS_STOCK_PRICE_KEY);
    }
    public String getStockInfo(String id, @Nullable String marketCode) {
        String productTypeCode;
        if(StringUtils.isDigit(id)) productTypeCode = DOMESTIC;         //숫자로만 이루어져 있으면 국내 상장 주식, 아니면 해외주식
        else productTypeCode = Optional.ofNullable(marketCode).orElse(NASDAQ); //시장코드가 들어가 있으면 해당 데이터로, 아니면 나스닥 고정
        String url = KisConstants.REST_BASE_URL + TOTAL_STOCK_INFO_URL + "?" + STOCK_INFO_PRODUCT_NO + id + "&" + STOCK_INFO_PRODUCT_TYPE_CODE + productTypeCode;
        JSONObject result = apiAction.get(url, KisConstants.TOTAL_STOCK_INFO_KEY);
        return result.toString();
    }
}
