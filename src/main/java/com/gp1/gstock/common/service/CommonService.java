package com.gp1.gstock.common.service;

import com.gp1.gstock.common.entity.MsgCd;

public interface CommonService {
    public void insertMsgCd(MsgCd msgCd);
    public MsgCd selectMsgCd(String cd);

}
