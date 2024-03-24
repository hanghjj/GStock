package com.gp1.gstock.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "GS_MSG_CD")
@SequenceGenerator(
        name = "MSG_SEQ_GEN",
        sequenceName = "SEQ_GS_MSG_CD",
        initialValue = 1,
        allocationSize = 1
)
@Data
@NoArgsConstructor
public class MsgCd {
    @Id
    @GeneratedValue(
        strategy= GenerationType.SEQUENCE,
        generator="MSG_SEQ_GEN"
    )
    @Column(name = "MSG_ID")
    private long msgId;
    private String code;
    private String message;

    public MsgCd(String cd, String msg) {
        this.code = cd;
        this.message = msg;
    }
}
