package com.benny.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/ordinary")
//套在class的path會讓底下的方法都會前置這個路徑"才能"訪問
public class CommonController {
    @RequestMapping(path = "/common.controller", method = RequestMethod.GET)
    public String processAction () {
        return "common";
    }

}
