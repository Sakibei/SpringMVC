package com.benny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MultiLangController {

    @Autowired
    private MessageSource ms;

    @GetMapping("/multiLang.controller")
    public String MultiLang() {
        String msg = ms.getMessage("program.error", null, LocaleContextHolder.getLocale());
        System.out.println("Locale: " + LocaleContextHolder.getLocale());
        System.out.println("msg: " + msg);
        return "multiLangResult";
    }



}
