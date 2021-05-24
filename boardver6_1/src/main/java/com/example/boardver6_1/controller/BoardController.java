package com.example.boardver6_1.controller;

import com.example.boardver6_1.model.dao.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
    @Autowired
    BoardDAO boardDAO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String boardList(){

        return "";
    }

}
