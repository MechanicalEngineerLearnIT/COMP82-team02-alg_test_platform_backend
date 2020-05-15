package com.example.demo.controller;


import com.example.demo.model.userinfo;
import com.example.demo.repository.userinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class userinfoController {


    @Autowired
    userinfoRepository userRepo;

    @RequestMapping("/getAllItems")
    @ResponseBody
    public List<userinfo> getAllItems(){
        return userRepo.getAllItems();
    }

    @RequestMapping("/getItem")
    @ResponseBody
    public userinfo getItem(@RequestParam("userEmail") String userEmail){
        return userRepo.getItem(userEmail);
    }

    @RequestMapping("/addItem")
    @ResponseBody
    public String addItem(@RequestParam("userEmail") String userEmail,@RequestParam("userPassword") String userPassword
                          ){
        if(userRepo.addItem(userEmail,userPassword) >= 1){
            return "User Added Successfully";
        }else{
            return "Something went wrong !";
        }
    }
    @RequestMapping("/deteteItem")
    @ResponseBody
    public String deteteItem(@RequestParam("userEmail") String userEmail){
        if(userRepo.deleteItem(userEmail) >= 1){
            return "User Deleted Successfully";
        }else{
            return "Something went wrong !";
        }
    }
}
