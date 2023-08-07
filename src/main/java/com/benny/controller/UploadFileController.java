package com.benny.controller;

import com.benny.model.PictrueService;
import com.benny.model.Picture;
import com.benny.model.PictureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadFileController {

    @Autowired
    private PictrueService pService;

    @GetMapping("/uploadfilemain.controller")
    public String processMainAction() {
        return "uploadFile";
    }

    @PostMapping(path = "/upload.controller", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String processAction(@RequestParam("myFiles") MultipartFile mf) throws IllegalStateException, IOException {
        String fileName = mf.getOriginalFilename();
        System.out.println("fileName:" + fileName);

        String saveFileDir = "/home/benny/upload/";
        File saveFilePath = new File(saveFileDir, fileName);

        byte[] b1 = mf.getBytes();

        //透過Service將圖片存入資料庫
        Picture p = new Picture(fileName, b1);
        pService.insert(p);

        mf.transferTo(saveFilePath);

        return "saveFilePath:" + saveFilePath +"/n" + "fileName:" + fileName + "/n" + "已存入資料庫";
    }
}