package com.example.boardver6_1.controller;

import com.example.boardver6_1.model.vo.UserEntity;
import org.springframework.ui.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyUtils {
    public static int getLoginUserPk(HttpServletRequest req) {
        if(req == null) { return 0; }
        return getLoginUser(req).getIuser();
    }

    public static UserEntity getLoginUser(HttpServletRequest req) {
        if(req == null) { return null; }
        HttpSession hs = req.getSession();
        return (UserEntity) hs.getAttribute("loginUser");
    }

    public static int getParamInt(String key, HttpServletRequest req) {
        String val = req.getParameter(key);
        int intVal = parseStringToInt(val);
        return intVal;
    }

    public static int parseStringToInt(String val) {
        try {
            int result = Integer.parseInt(val);
            return result;
        } catch(Exception e) {
            return 0;
        }
    }
/*
    public static void openJSP(String title, String page, HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        req.setAttribute(Const.TITLE, title);
        req.setAttribute(Const.PAGE, page);
        String jsp = "/WEB-INF/view/template.jsp";
        req.getRequestDispatcher(jsp).forward(req, res);
    }
*/
    public static void setTemplate(Model model, String title, String page){
        model.addAttribute("title",title);
        model.addAttribute("page",page);
    }
    public static final String TEMPLATE = "template";

}