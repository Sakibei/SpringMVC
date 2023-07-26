package com.benny.controller;

import com.benny.model.Members;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MembersController {
    @GetMapping("/membersmain.controller")
    public String method(Model m) {
        Members mb1 = new Members();
        m.addAttribute("members", mb1);
        return "members";
    }
}
