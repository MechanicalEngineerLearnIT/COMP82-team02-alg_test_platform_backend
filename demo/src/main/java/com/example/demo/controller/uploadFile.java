package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.SocketException;


@RestController
@CrossOrigin(value = "http://localhost:8080", maxAge = 3600)
public class uploadFile {

    @RequestMapping(value = "/uploadUnknown")
    public String uploadUnknown(MultipartFile file) throws SocketException, IOException {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 在file文件夹中创建名为fileName的文件
        OutputStreamWriter op = new OutputStreamWriter(new FileOutputStream("//home//ubuntu//integrity_jar//data//unknown//" + fileName), "UTF-8");
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

    @RequestMapping(value = "/uploadKnown")
    public String uploadKnown(MultipartFile file) throws SocketException, IOException {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 在file文件夹中创建名为fileName的文件
        OutputStreamWriter op = new OutputStreamWriter(new FileOutputStream("//home//ubuntu//integrity_jar//data//known//" + fileName), "UTF-8");
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