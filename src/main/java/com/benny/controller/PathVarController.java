package com.benny.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PathVarController {

    @RequestMapping(path="/member/{mid}",method = RequestMethod.GET)
    public String processAction(@PathVariable("mid") String midId , Model m){
        m.addAttribute("midgo",midId);
        return "/resultInfo.jsp";
    }

}
