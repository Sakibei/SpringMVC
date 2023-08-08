package com.benny.controller;

import com.benny.model.Profiles;
import com.benny.model.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RestCrudController {

    @Autowired
    private ProfilesService pService;

    //    Restful api(style)
    @PostMapping(path = "/profiles", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String processInsertAction(
            @RequestParam("userName") String userName,
            @RequestParam("userAddress") String userAddress,
            @RequestParam("userPhone") String userPhone){

        Profiles insertBean = new Profiles(userName, userAddress, userPhone);
        pService.insert(insertBean);
        return "Insert Complete";
        //      json files
    }

    // insert 的另一種寫法(塞整筆資料過去)(在postman利用Body > raw > json 寫入)
    @PostMapping(path = "/profiles2")
    @ResponseBody
    public Profiles processInsertAction(@RequestBody Profiles pBean) {
        return pService.insert(pBean);
    }

    @GetMapping("/profiles/{pid}")
    @ResponseBody
    public String processQueryAction(@PathVariable("pid") int pid){
        Profiles resultBean = pService.findById(pid);

        if(resultBean != null){
            return "Result " + resultBean.getId() + " " + resultBean.getName() + " " + resultBean.getAddress() + " " + resultBean.getPhone();
        }

        return "no result";
    }

    @GetMapping("profiles")
    @ResponseBody
    public List<Profiles> processQueryAllAction(){
        return pService.findAll();
    }

    @PutMapping("/profiles/{pid}")
    @ResponseBody
    public String processUpdateAction(@PathVariable("pid") int pid,
                                              @RequestParam("userName") String userName,
                                              @RequestParam("userAddress") String userAddress,
                                              @RequestParam("userPhone") String userPhone){
        Profiles updateBean = new Profiles(pid, userName, userAddress, userPhone);
        pService.update(updateBean);
        return "Update Complete";
    }

    @DeleteMapping("profiles/{pid}")
    @ResponseBody
    public String processDeleteAction(@PathVariable("pid") int pid){
        pService.deleteById(pid);
        return "Delete Complete";
    }

}
