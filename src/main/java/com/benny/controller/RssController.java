package com.benny.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class RssController {

    public String result;

    //如果出現亂碼請在tomcat的vm option加上    -Dfile.encoding=UTF-8
    @GetMapping(path = "/rssreader.controller", produces = "application/xml;charset=UTF-8")
    @ResponseBody
    public String processRssAction() throws InterruptedException {
        Thread t1 = new Thread(){
            public void run() {
                try {
                    URL url = new URL("https://www.mohw.gov.tw/rss-16-1.html");
                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.connect();

                    BufferedReader br1 = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    //預設空字串
                    String data = "";
                    result = "";

                    while((data = br1.readLine()) != null){
                        result += data;
                    }

                    br1.close();
                    conn.disconnect();

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        t1.join();
        System.out.println("result: " + result);
        return result;

//      回傳過去還是xml
    }
}
