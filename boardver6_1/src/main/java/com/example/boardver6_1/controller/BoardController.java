package com.example.boardver6_1.controller;

import com.example.boardver6_1.model.dao.BoardCmtDAO;
import com.example.boardver6_1.model.dao.BoardDAO;
import com.example.boardver6_1.model.vo.BoardCmtDomain;
import com.example.boardver6_1.model.vo.BoardCmtEntity;
import com.example.boardver6_1.model.vo.BoardDTO;
import com.example.boardver6_1.model.vo.BoardDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
    @Autowired
    BoardDAO boardDAO;
    @Autowired
    BoardCmtDAO boardCmtDAO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String boardList(Model model,
                            @RequestParam(value = "page", defaultValue = "1")int page,
                            BoardDTO boardDTO){
        if(boardDTO.getSearchType() != 0 && boardDTO.getSearchText() != null && !boardDTO.getSearchText().equals("")){

        }

        boardDTO.setRecordCnt(5);
        int startIdx = (page - 1) * boardDTO.getRecordCnt();
        boardDTO.setStartIdx(startIdx);
        int totalPage = boardDAO.getPage(boardDTO);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("list",boardDAO.selBoardList(boardDTO));

        MyUtils.setTemplate(model,"list","board/boardList");
        return MyUtils.TEMPLATE;
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String boardDetail(Model model,
                              @RequestParam(value = "iboard")int iboard){

        model.addAttribute("data",boardDAO.selBoard(iboard));
        MyUtils.setTemplate(model,"list","board/boardDetail");
        return MyUtils.TEMPLATE;
    }

    @ResponseBody
    @RequestMapping(value = "/cmtInsSel", method = RequestMethod.GET)
    public String boardCmtInsSel(@RequestBody BoardCmtDomain par){ //리스트
        System.out.println(par.getIboard());

        return "";
    }

    @ResponseBody
    @RequestMapping(value = "/cmtInsSel", method = RequestMethod.POST)
    public int boardCmtInsSelF(@RequestBody BoardCmtEntity par){ //등록
        par.setIuser(10);
        int result = boardCmtDAO.insBoardCmt(par);
        System.out.println(result);
        return result;
    }
}
