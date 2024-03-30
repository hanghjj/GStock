package com.gp1.gstock.common.service;

import com.gp1.gstock.common.Exception.CustomException;
import com.gp1.gstock.common.entity.MsgCd;
import com.gp1.gstock.common.entity.User;

import java.util.List;

public interface CommonService {
    public void insertMsgCd(MsgCd msgCd) throws CustomException;
    public MsgCd selectMsgCd(String cd);
    public void insertUser(User user) throws CustomException;
    public User getUser(String id) throws CustomException;
    public List<User> getAllUser() throws CustomException;
    public User signIn(User user);

}
