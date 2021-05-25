package com.example.boardver6_1.model.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardDTO {
    private int startIdx;
    private int recordCnt;
    private int searchType;
    private String searchText;
}
