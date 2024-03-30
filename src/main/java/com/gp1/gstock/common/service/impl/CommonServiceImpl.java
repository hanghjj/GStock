package com.gp1.gstock.common.service.impl;

import com.gp1.gstock.common.Exception.CustomException;
import com.gp1.gstock.common.entity.MsgCd;
import com.gp1.gstock.common.entity.User;
import com.gp1.gstock.common.repository.MsgCdRepository;
import com.gp1.gstock.common.service.CommonService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@Transactional
public class CommonServiceImpl implements CommonService {

    private final EntityManager em;
    private final MsgCdRepository repository;
    private final PasswordEncoder encoder;

    @Override
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

    @Override
    public void insertUser(User user) throws CustomException {
        String initialPw = user.getPassword();
        String encodedPw = encoder.encode(initialPw);
        user.setPassword(encodedPw);
        em.persist(user);
    }

    @Override
    public User getUser(String id) throws CustomException {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getAllUser() throws CustomException {
        return em.createQuery("SELECT U FROM GS_USER U",User.class)
                 .getResultList().stream().toList();
    }

    @Override
    public User signIn(User logUser) {
        User user = em.find(User.class,logUser.getId());
        if(encoder.matches(logUser.getPassword(), user.getPassword())) { // pw 일치 여부 확인
            return user;
        }else{
            return null;
        }
    }
}
