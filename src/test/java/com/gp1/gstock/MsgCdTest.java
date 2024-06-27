package com.gp1.gstock;

import com.gp1.gstock.common.entity.MsgCd;
import com.gp1.gstock.common.service.CommonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MsgCdTest {
    @Autowired
    CommonService commonService;

    @Test
    @DisplayName("메세지 코드 insert test")
    void insertTest() {
        //String cd = "stock_duplicate";
        //String msg = "이미 등록된 주식입니다.";
        //assertThatCode(()->commonService.insertMsgCd(new MsgCd(cd,msg))).doesNotThrowAnyException();
    }


    @Test
    @DisplayName("메세지 코드 selectTest")
    void selectTest() {
        String cd = "stock.duplicate";
        //assertThat(commonService.selectMsgCd(cd).getMessage()).isEqualTo("이미 등록된 주식입니다.");
    }
}
