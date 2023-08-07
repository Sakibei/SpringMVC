package com.benny.controller;

import com.benny.model.Members;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MembersController {
    @GetMapping("/membersmain.controller")
    public String method(Model m) {
        Members mb1 = new Members();
        m.addAttribute("members", mb1);
        return "members";
    }

    @PostMapping("/addMembers")
    public String processAction(@ModelAttribute("members") Members mem2, BindingResult result, Model m2) {
        if(result.hasErrors()) {
            return "membersError";
        }

        m2.addAttribute("mName", mem2.getMemberName());
        m2.addAttribute("mAge", mem2.getAge());
        m2.addAttribute("mGender", mem2.getGender());
        return "membersResult";
    }
}
