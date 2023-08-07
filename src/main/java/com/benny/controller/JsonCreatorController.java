package com.benny.controller;

import com.benny.model.House;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class JsonCreatorController {

    @GetMapping(path = "/jsoncreate1.controller")
    @ResponseBody
    public String processAction1() throws JsonProcessingException {
        House h1 = new House(100,"myHouse");

        ObjectMapper om = new ObjectMapper();
        String jsonStr = om.writeValueAsString(h1);
        House resultBean = om.readValue(jsonStr, House.class);
        System.out.println(resultBean.getHouseid() + " " + resultBean.getHousename());

        return "jsonStr=" + jsonStr;
    }

    @GetMapping(path = "/jsoncreate2.controller")
    @ResponseBody
    public House processAction2() throws JsonProcessingException {
        House h1 = new House(101,"Nice House");
        return h1;
    }

    @GetMapping(path = "/jsoncreate3.controller")
    @ResponseBody
    public ArrayList<House> processAction3() throws JsonProcessingException {
        House h1 = new House(101,"Big House");
        House h2 = new House(102,"Small House");

        ArrayList<House> lists = new ArrayList<House>();
        lists.add(h1);
        lists.add(h2);

        return lists;
    }

}

