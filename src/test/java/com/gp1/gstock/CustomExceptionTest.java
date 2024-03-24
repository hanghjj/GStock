package com.gp1.gstock;

import com.gp1.gstock.common.Exception.CustomException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThatCode;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CustomExceptionTest {
    @Test
    void ThrowTest() {
        assertThatCode(()->{throw new CustomException("stock_duplicate");})
                .isInstanceOf(CustomException.class);
    }
}
