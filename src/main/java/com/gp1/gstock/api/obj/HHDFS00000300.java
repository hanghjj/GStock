package com.gp1.gstock.api.obj;

import com.gp1.gstock.stock.dto.KisStockPrice;
import com.gp1.gstock.stock.utils.StockUtils;
import lombok.Data;

@Data
public class HHDFS00000300 {
    private String rsym;
    private String zdiv;
    private String base;
    private String pvol;
    private String last;
    private String sign;
    private String diff;
    private String rate;
    private String tvol;
    private String tamt;
    private String ordy;
    private String rt_cd;
    private String msg_cd;
    private String msg1;

    public KisStockPrice convert(){
        KisStockPrice a = new KisStockPrice();
        a.setStckShrnIscd(this.rsym.replaceAll("DNAS",""));
        a.setRprsMrktKorName("미국 나스닥");
        a.setStckPrpr(Double.parseDouble(this.last));
        a.setPrdyVrss(Double.parseDouble(this.diff));
        a.setPrdyVrssSign(StockUtils.getVrssSign(this.sign));
        a.setPrdyCtrt(Double.parseDouble(this.rate));
        return a;
    }
}
