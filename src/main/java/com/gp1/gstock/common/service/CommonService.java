package com.gp1.gstock.common.service;

import com.gp1.gstock.common.Exception.CustomException;
import com.gp1.gstock.common.entity.MsgCd;

public interface CommonService {
    public void insertMsgCd(MsgCd msgCd) throws CustomException;
    public MsgCd selectMsgCd(String cd);

}
