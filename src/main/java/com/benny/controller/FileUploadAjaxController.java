package com.benny.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadAjaxController {

    @PostMapping("/uploadfile.controller")
    @ResponseBody
    public String processAction(@RequestParam("myFile")MultipartFile mf) throws IOException {
        String fileName = mf.getOriginalFilename();
        System.out.println("fileName: " + fileName);

        String saveFileDir = "c:/temp/upload";
        File saveFilePath = new File(saveFileDir, fileName);
        mf.transferTo(saveFilePath);

        System.out.println(saveFilePath);

        return "Save File Path:" + saveFilePath;
    }
}
