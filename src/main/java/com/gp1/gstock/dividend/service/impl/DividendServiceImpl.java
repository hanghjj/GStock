package com.gp1.gstock.dividend.service.impl;

import com.gp1.gstock.common.Exception.CustomException;
import com.gp1.gstock.common.constants.BizConstants;
import com.gp1.gstock.common.utils.DateTimeUtils;
import com.gp1.gstock.common.utils.StringUtils;
import com.gp1.gstock.dividend.entity.Dividend;
import com.gp1.gstock.dividend.entity.DividendId;
import com.gp1.gstock.dividend.repository.DividendRepository;
import com.gp1.gstock.dividend.service.DividendService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.gp1.gstock.common.constants.BizConstants.YAHOO_DIVIDEND_PREFIX;
import static com.gp1.gstock.common.constants.BizConstants.YAHOO_DIVIDEND_SUFFIX;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class DividendServiceImpl implements DividendService {

    private final EntityManager em;
    private final DividendRepository repository;

    @Override
    public void insertDiviend(Dividend dividend) {
        repository.save(dividend);
    }

    @Override
    public void updateDiviend(Dividend dividend) {
        em.merge(dividend);
    }

    @Override
    public Dividend selectDividend(String bseYm, String srtnCd) {
        return em.find(Dividend.class, new DividendId(srtnCd, bseYm));
    }

    @Override
    public List<Dividend> selectBySrtnCd(String srtnCd) {
        return null;
    }

    @Override
    public void deleteDividend(Dividend dividend) {
        DividendId id = dividend.getId();
        repository.deleteById(id);
    }

    @Override
    public List<Dividend> searchDividendPayHistory(String srtnCd) throws CustomException{
        List<Dividend> resultList = new ArrayList<>();
        String ticker = "";
        if(StringUtils.isDigit(srtnCd)) ticker = srtnCd+".KS";
        else ticker = srtnCd;
        String url = YAHOO_DIVIDEND_PREFIX+ticker+YAHOO_DIVIDEND_SUFFIX;
        log.info("요청 URL : " + url);
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new CustomException(BizConstants.DEFAULT_ERR_MSG);
        }
        Elements list  = doc.select("tbody").select("tr");
        for (Element el : list) {
            Elements temp = el.getElementsByTag("td");
            List<String> divList = temp.stream().map(element -> {
                String str = element.text();
                str = str.replace(" Dividend","");
                return str;
            }).toList();
            String bseYm = DateTimeUtils.convertDateFormat(divList.get(0),  new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH),  new SimpleDateFormat("yyyyMM"));
            //배당락일임
            Double dps = Double.parseDouble(divList.get(1));
            Dividend dividend = new Dividend(srtnCd, bseYm, dps);
            boolean isExists = repository.existsById(new DividendId(srtnCd,bseYm));
            if(!isExists) repository.save(dividend);
            resultList.add(dividend);
        }
        return resultList;
    }
}
