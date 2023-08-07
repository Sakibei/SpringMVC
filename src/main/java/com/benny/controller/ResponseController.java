package com.benny.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class ResponseController {

    // 測試 restful api 風格
    // 回傳純文字格式和json格式

    //    @GetMapping(path = "/response.controller") // 預設是回傳json格式
    @GetMapping(path = "/response.controller", produces = "text/html;charset=UTF-8") //加了produces改為純文本格式
    @ResponseBody   // 這個annotation會讓return的字串直接回傳給瀏覽器，而不會再去找view,
    // 但是如果return的是物件，則會自動轉成json格式，預設是回傳json格式
    public String method() {
        return "How da o";
    }

    // 這個方法會回傳一個ResponseEntity物件，其中包含了一個字串和一個HttpStatus物件，可以用來回傳自訂的狀態碼
    @GetMapping(path = "/responseentity.controller")
    public ResponseEntity<String> processResponseEntityAction() {
        return new ResponseEntity<String>("Custom Status Code(403 Forbidden)", HttpStatus.FORBIDDEN);
    }

    @GetMapping(path = "/bytearrayimage.controller", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public byte[] processByteArrayImageAction(HttpServletRequest request) throws IOException {
        InputStream is1 = request.getServletContext().getResourceAsStream("/WEB-INF/resources/images/images06.jpg");
        return IOUtils.toByteArray(is1);
    }

}
