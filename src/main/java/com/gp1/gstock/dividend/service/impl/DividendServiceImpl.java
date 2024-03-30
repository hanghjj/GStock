package com.gp1.gstock.dividend.service.impl;

import com.gp1.gstock.dividend.entity.Dividend;
import com.gp1.gstock.dividend.entity.DividendId;
import com.gp1.gstock.dividend.service.DividendService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class DividendServiceImpl implements DividendService {

    private final EntityManager em;

    @Override
    public void insertDiviend(Dividend dividend) {

    }

    @Override
    public void updateDiviend(Dividend dividend) {

    }

    @Override
    public Dividend selectDividend(String bseYm, String srtnCd) {
        return em.find(Dividend.class, new DividendId(bseYm,srtnCd));
    }

    @Override
    public List<Dividend> selectBySrtnCd(String srtnCd) {
        return null;
    }

    @Override
    public void deleteDividend(Dividend dividend) {

    }
}
