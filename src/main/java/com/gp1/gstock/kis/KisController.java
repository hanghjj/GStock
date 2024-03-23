package com.gp1.gstock.kis;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.gp1.gstock.kis.KisConstants.*;

@Controller
@RequestMapping("/kis")
public class KisController {

    @Autowired
    private AccessTokenManager accessTokenManager;

    private final WebClient webClient;
    private String path;
    private String tr_id;
    private String token;

    public KisController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(REST_BASE_URL).build();
    }

    @GetMapping("/main")
    public String index(Model model) {
        //System.out.println(accessTokenManager.getAccessToken());
        return "index";
    }

    public String getStringToday() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return localDate.format(formatter);
    }

    public String getJobDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
    @ApiOperation(value = "주식 현재 시세 조회", notes = "국내주식 현재 시세 조회")
    @GetMapping("/inquiry/{id}")
    public Mono<String> getStockPrice(@PathVariable("id") String id, Model model){
        this.token = accessTokenManager.getAccessToken();
        String url = REST_BASE_URL + DOMESTIC_STOCK_URL + "?fid_cond_mrkt_div_code=J&fid_input_iscd=" + id;
        return webClient.get()
                .uri(url)
                .header("content-type","application/json")
                .header("authorization","Bearer " + token)
                .header("appkey",APP_KEY)
                .header("appsecret",APP_SECRET_KEY)
                .header("tr_id",DOMESTIC_STOCK_PRICE_KEY)
                .retrieve()
                .bodyToMono(Body.class)
                .doOnSuccess(body -> {
                    model.addAttribute("equity", body.getOutput());
                    model.addAttribute("jobDate", getJobDateTime());
                })
                .doOnError(result -> System.out.println("*** error: " + result))
                .thenReturn("index");
    }
}