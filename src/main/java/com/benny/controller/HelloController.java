package com.benny.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

public class HelloController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userName = request.getParameter("userName");

        Map<String, String> errors = new HashMap<>();
        request.setAttribute("errors", errors);

        if (userName == null || userName.length() == 0) {
            errors.put("name", "用户名不能為空");
        }

        if (errors != null && !errors.isEmpty()) {
            return new ModelAndView("form");
        }

        HttpSession session = request.getSession();
        session.setAttribute("userName", userName);
        return new ModelAndView("Success");
    }

}
