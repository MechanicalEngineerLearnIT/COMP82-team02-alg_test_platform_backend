package com.example.demo.controller;

import org.json.JSONString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.SocketException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import com.alibaba.fastjson.JSON;


@RestController
@CrossOrigin(value = "http://localhost:8080", maxAge = 3600)
public class uploadFile {


    @RequestMapping(value = "/upload")
    public String upload(MultipartFile file) throws SocketException, IOException {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 在file文件夹中创建名为fileName的文件
        OutputStreamWriter op = new OutputStreamWriter(new FileOutputStream("src/main/resources/uploadFiles" + fileName), "UTF-8");
        // 获取文件输入流
        InputStreamReader inputStreamReader = new InputStreamReader(file.getInputStream());
        char[] bytes = new char[12];
        // 如果这里的bytes不是数组，则每次只会读取一个字节，例如test会变成 t   e     s    t
        while (inputStreamReader.read(bytes) != -1) {
            op.write(bytes);
        }
        // 关闭输出流
        op.close();
        // 关闭输入流
        inputStreamReader.close();
        return "上传成功";


    }


}