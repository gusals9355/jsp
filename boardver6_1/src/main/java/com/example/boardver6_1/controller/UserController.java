package com.example.boardver6_1.controller;

import com.example.boardver6_1.model.dao.UserDAO;
import com.example.boardver6_1.model.vo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user/*")
public class UserController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model){

        MyUtils.setTemplate(model,"login","user/userLogin");
        return MyUtils.TEMPLATE;
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginF(Model model, UserEntity vo, HttpSession session){
        UserEntity result = userDAO.selUser(vo);
        if(result == null){
            model.addAttribute("errMsg","다시 확인해");
        }else if(vo.getUpw().equals(result.getUpw())){
            result.setUpw(null);
            session.setAttribute("loginUser",result);
            return "redirect:/board/list";
        }
        return "redirect:login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, HttpSession session, HttpServletRequest request){
        session.invalidate();

        return "redirect:login";
    }

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String join(Model model){

        MyUtils.setTemplate(model,"join", "user/userJoin");
        return MyUtils.TEMPLATE;
    }
    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String joinF(Model model, UserEntity vo){
        userDAO.insertUser(vo);
        return "redirect:login";
    }

    @ResponseBody
    @RequestMapping(value = "/idChk", method = RequestMethod.POST)
    public int idChk(@RequestBody UserEntity vo){
        int result = 0;
        String dbId = userDAO.UserIdChk(vo);
        if(dbId != null && vo.getUid().equals(dbId)){
            result = 1;
            return result;
        }
        return result;
    }
}