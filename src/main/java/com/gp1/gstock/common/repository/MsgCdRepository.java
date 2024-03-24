package com.gp1.gstock.common.repository;

import com.gp1.gstock.common.entity.MsgCd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MsgCdRepository extends JpaRepository<MsgCd, Long> {

    public List<MsgCd> findByCode(String code);
}
