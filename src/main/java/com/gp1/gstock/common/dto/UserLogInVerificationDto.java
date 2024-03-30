package com.gp1.gstock.common.dto;

import com.gp1.gstock.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserLogInVerificationDto extends BaseEntity {
    String id;
    boolean verified;
}
