package com.gp1.gstock.stock.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.gp1.gstock.common.aop.AopController;
import com.gp1.gstock.api.obj.CTPF1002R;
import com.gp1.gstock.api.obj.CustomObjectMapper;
import com.gp1.gstock.api.obj.FHKST01010100;
import com.gp1.gstock.stock.dto.KisStockPrice;
import com.gp1.gstock.stock.dto.SrtnCdDto;
import com.gp1.gstock.stock.dto.StockDto;
import com.gp1.gstock.stock.dto.StockPriceDto;
import com.gp1.gstock.stock.entity.Stock;
import com.gp1.gstock.stock.kis.KisConstants;
import com.gp1.gstock.stock.kis.KisService;
import com.gp1.gstock.stock.service.StockService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/stock")
@AllArgsConstructor
@Tag(name = "Stock", description = "주식 관련 API")
public class StockController extends AopController{
    private final StockService stockService;
    private final KisService kisService;
    private final CustomObjectMapper mapper;

    @GetMapping("/getstock")
    @Tag(name = "Stock", description = "DB에 저장된 주식 정보 조회")
    public ResponseEntity<Stock> getStock(String bseDt, String srtnCd) {
        return ResponseEntity.status(HttpStatus.OK).body(stockService.getStock(bseDt, srtnCd));
    }

    @GetMapping("/code/{name}")
    @Tag(name = "Stock", description = "종목명, 종목코드 조회")
    public ResponseEntity<List<SrtnCdDto>> getSrtnCd(@PathVariable("name") String name) throws JsonProcessingException {
        List<SrtnCdDto> modelList = new ArrayList<>();
        String url = "https://m.stock.naver.com/api/json/search/searchListJson.nhn?keyword=" + name;
        Document doc = null;
        try {
            doc = Jsoup.connect(url).header("content-type", "application/json;charset=UTF-8")
                    .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                    .header("accept-encoding", "gzip, deflate, br")
                    .header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
                    .ignoreContentType(true).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String stockJsonList = doc.text();

        System.out.println(stockJsonList);

        JSONArray array = new JSONObject(stockJsonList).getJSONObject("result").getJSONArray("d");
        modelList = array.toList().stream().map(o ->{
            try {
                Gson gson = new Gson();
                return mapper.readValue(gson.toJson(o),SrtnCdDto.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(modelList);
    }

    @GetMapping("/kis/inquiry/{id}")
    @Tag(name = "Stock", description = "[" + KisConstants.DOMESTIC_STOCK_PRICE_KEY + "] 한국투자증권 주식 현재가 조회")
    public ResponseEntity<StockPriceDto> getKisStockPrice(@PathVariable("id") String id) throws JsonProcessingException {
        Gson gson = new Gson();
        //주식 가격 조회 및 Insert
        String stockPrice = kisService.getDomesticStockPrice(id);
        JSONObject output = new JSONObject(stockPrice).getJSONObject("output");
        //convert json to apiObj
        FHKST01010100 fhkst01010100 = mapper.readValue(output.toString(), FHKST01010100.class);
        // apiObj to KisStockPrice
        KisStockPrice convert = fhkst01010100.convert(id);
        //convert KisStockPrice to StockPrice
        StockPriceDto stockPriceDto = convert.convert();
        //insert into Table
        stockService.saveStock(stockPriceDto);
        //entityManger setting
        return ResponseEntity.status(200).body(stockPriceDto);
    }

    @GetMapping("/kis/info/{id}")
    @Tag(name = "Stock", description = "[" + KisConstants.DOMESTIC_STOCK_INFO_KEY + "] 한국투자증권 주식 기본 정보 조회")
    public ResponseEntity<StockDto> getKisStockInfo(@PathVariable("id") String id) throws JsonProcessingException {
        String stockInfo = kisService.getDomesticStockInfo(id);
        JSONObject output = new JSONObject(stockInfo).getJSONObject("output");
        //convert json to apiObj
        CTPF1002R ctpf1002R = mapper.readValue(output.toString(), CTPF1002R.class);
        //convert apiObj to StockDto
        StockDto stockDto = ctpf1002R.convert();
        log.info("주식 정보 조회 " + ctpf1002R.toString());
        stockService.saveStock(stockDto);
        return ResponseEntity.status(200).body(stockDto);
    }
}
