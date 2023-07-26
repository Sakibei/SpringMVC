package com.benny.controller;

import com.benny.model.Account;
import com.benny.model.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginSystemController {

    @GetMapping("/loginsystem.controller")
    public String login(){
        return "login_system";
    }

    @Autowired
    private AccountService aService;

    @PostMapping("/checklogin.controller")
    public String processAction(@RequestParam("userName") String user, @RequestParam("userPwd") String pwd, Model m) {

        Map<String, String> errors = new HashMap<>();
        m.addAttribute("errors", errors);

        if(user==null || user.length()==0) {
            errors.put("name", "name is required");
        }

        if(pwd==null || pwd.length()==0) {
            errors.put("pwd", "user password is required");
        }

        if(errors!=null && !errors.isEmpty()) {
            return "login_system";
        }

        boolean resultStatus = aService.checkLogin(new Account(user, pwd));

        if(resultStatus) {
            m.addAttribute("user", user);
            m.addAttribute("pwd", pwd);
            return "login_success";
        }

        errors.put("msg", "username or password is not correct");
        return "login_system";
    }

}
