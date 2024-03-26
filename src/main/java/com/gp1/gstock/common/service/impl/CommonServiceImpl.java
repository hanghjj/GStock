package com.gp1.gstock.common.service.impl;

import com.gp1.gstock.common.Exception.CustomException;
import com.gp1.gstock.common.entity.MsgCd;
import com.gp1.gstock.common.repository.MsgCdRepository;
import com.gp1.gstock.common.service.CommonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CommonServiceImpl implements CommonService {

    private final EntityManager em;
    private final MsgCdRepository repository;

    @Override
    @Transactional()
    public void insertMsgCd(MsgCd msgCd) throws CustomException {
        String code = msgCd.getCode();
        if (!code.equals(Optional.ofNullable(selectMsgCd(code)).orElse(new MsgCd()).getCode())) em.persist(msgCd);
        else throw new CustomException("message.duplicate.error");

    }

    @Override
    public MsgCd selectMsgCd(String cd) {
        List<MsgCd> resultList = repository.findByCode(cd);
        return resultList.stream()
                .findFirst()
                .orElse(new MsgCd());
    }
}
