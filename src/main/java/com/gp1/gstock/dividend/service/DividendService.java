package com.gp1.gstock.dividend.service;

import com.gp1.gstock.dividend.entity.Dividend;

import java.util.List;

public interface DividendService {

    public void insertDiviend(Dividend dividend);
    public void updateDiviend(Dividend dividend);
    public Dividend selectDividend(String bseYm, String srtnCd);
    public List<Dividend> selectBySrtnCd(String srtnCd);
    public void deleteDividend(Dividend dividend);
}
