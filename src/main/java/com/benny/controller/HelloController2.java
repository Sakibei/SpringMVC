package com.benny.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes(names = {"userName"})
public class HelloController2 {

    @RequestMapping(path = "/hello2main.controller", method = RequestMethod.GET)
    public String processMainAction() {
        return "form";
    }

    @RequestMapping(path = "/hello2.controller", method = {RequestMethod.GET, RequestMethod.POST})
    public String processAction(@RequestParam("userName") String userName, Model m) {

        Map<String,String> errors = new HashMap<>();
        m.addAttribute("errors", errors);

        if(userName==null || userName.length()==0) {
            errors.put("name", "使用名稱不可為空");
        }

        if(errors!=null && !errors.isEmpty()) {
            return "form";
        }

        m.addAttribute("userName",userName);
        return "Success";
    }

}
