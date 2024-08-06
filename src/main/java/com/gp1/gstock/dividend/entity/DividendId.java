package com.gp1.gstock.dividend.entity;

import com.gp1.gstock.common.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DividendId extends BaseEntity {


    @Schema(name = "종목코드")
    @Column(name = "SRTN_CD")
    private String srtnCd;

    @Schema(name = "기준년월(배당락일 기준)")
    @Column(name = "BSE_YM")
    private String bseYm;

}
