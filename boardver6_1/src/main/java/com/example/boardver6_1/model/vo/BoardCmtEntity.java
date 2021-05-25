package com.example.boardver6_1.model.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardCmtEntity {
    private int icmt;
    private int iboard;
    private int iuser;
    private String cmt;
    private String regdate;
}
