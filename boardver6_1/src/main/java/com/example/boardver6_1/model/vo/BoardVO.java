package com.example.boardver6_1.model.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardVO {
    private int iboard;
    private String title;
    private String ctnt;
    private int iuser;
    private String regdt;
    private String unm;
    private int sIdx;
    private int page;
    private String search;
}