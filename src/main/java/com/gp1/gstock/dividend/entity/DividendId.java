package com.gp1.gstock.dividend.entity;

import com.gp1.gstock.common.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Embeddable
@Data
@AllArgsConstructor
public class DividendId extends BaseEntity {
    @Schema(name = "기준년월")
    private String bseYm;

    @Schema(name = "종목코드")
    private String srtnCd;

}
