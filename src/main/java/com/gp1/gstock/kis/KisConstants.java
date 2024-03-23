package com.gp1.gstock.kis;

public final class KisConstants {
    public static final String REST_BASE_URL = "https://openapi.koreainvestment.com:9443";
    public final static String GRANT_INFO = "client_credentials";

    public final static String APP_KEY = "PSO4fj0gaiojDFaNm6vOQbuvrXk8PamP0dpm";
    public final static String APP_SECRET_KEY = "5Uv5dsYod3QYTMDQsyayjmdeEoyMYf2x9C77uhpGZdKGx5USsBwx7m9PnlkaiYw7+JaGzKg6nXeFYGPk4LaGJ16PRBO8WT2ioGZFR/QXG8MWUuysou0IoxAyUQkb70Pqm00xCSrhg2WdQNY59HWO7DJ+oibjq0O4r0OanAKjiKzKA21Y8GA=";

    //STOCK INFO
    public final static String DOMESTIC_STOCK_INFO_URL = "/uapi/domestic-stock/v1/quotations/search-stock-info";
    public final static String DOMESTIC_STOCK_INFO_KEY = "CTPF1002R";
    public final static String DOMESTIC_STOCK_INFO_QUERY = "?prdt_type_cd=300&pdno=";

    //STOCK PRICE
    public final static String DOMESTIC_STOCK_URL = "/uapi/domestic-stock/v1/quotations/inquire-price";
    public final static String DOMESTIC_STOCK_PRICE_KEY = "FHKST01010100";
    public final static String DOMESTIC_STOCK_PRICE_QUERY = "?fid_cond_mrkt_div_code=J&fid_input_iscd=";





}
