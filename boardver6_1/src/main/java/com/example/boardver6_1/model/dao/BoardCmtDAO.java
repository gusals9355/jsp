package com.example.boardver6_1.model.dao;

import com.example.boardver6_1.model.vo.BoardCmtDomain;
import com.example.boardver6_1.model.vo.BoardCmtEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("boardCmtDAO")
public interface BoardCmtDAO {

    int insBoardCmt(BoardCmtEntity param);
    List<BoardCmtDomain> selBoardCmtList(BoardCmtEntity param);
}
