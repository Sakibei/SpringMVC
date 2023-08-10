package com.benny.controller;

import com.benny.model.Users;
import com.benny.model.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class UsersCheckConrtroller {

    @Autowired
    private UsersService uService;

    @PostMapping("/accountcheck.controller")    //@RequestBody 要求傳入為json
    public ResponseEntity<String> processAction(@RequestBody Users user){
        boolean status = uService.checkLogin(user);

        if(status){
            return new ResponseEntity<String>("Y", HttpStatus.OK);
        }
        return new ResponseEntity<String>("N", HttpStatus.OK);
        //  只會接收到   Y or N
    }
}
