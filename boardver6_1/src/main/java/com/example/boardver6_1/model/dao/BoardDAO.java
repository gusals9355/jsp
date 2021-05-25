package com.example.boardver6_1.model.dao;

import com.example.boardver6_1.model.vo.BoardDTO;
import com.example.boardver6_1.model.vo.BoardDomain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("boardDAO")
public interface BoardDAO {

    List<BoardDomain> selBoardList(BoardDTO boardDTO);
    int getPage(BoardDTO boardDTO);
    BoardDomain selBoard(int iboard);

}
