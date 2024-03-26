package com.gp1.gstock;

import com.gp1.gstock.common.Exception.CustomException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatCode;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CustomExceptionTest {
    @Test
    void ThrowTest() throws CustomException {
        String cd = "stock.preregistered.param";
        assertThatCode(()->{throw new CustomException(cd, Collections.singletonList("삼성전자"));})
                .isInstanceOf(CustomException.class);
    }
}
