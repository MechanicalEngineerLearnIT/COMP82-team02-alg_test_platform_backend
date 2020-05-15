package com.example.demo.controller;


import com.example.demo.model.userinfo;
import com.example.demo.repository.userinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
controller  for  user logIN and register

 */
@RestController
public class userinfoController {


    @Autowired
    userinfoRepository userRepo;

    @RequestMapping("/getAllUsersInfo")
    @ResponseBody
    public List<userinfo> getAllItems() {
        return userRepo.getAllItems();
    }

    /*
    input userEmail,userPassword
    output log in Successfully/ email dos not exist
     */
    @RequestMapping("/login")
    @ResponseBody
    public String getItem(@RequestParam("userEmail") String userEmail, @RequestParam("userPassword") String userPassword) {
        String userPasswordFromMySQL = userRepo.getItem(userEmail);
        if (userPasswordFromMySQL.equals("email dos not exist")) {
            return "email does not exist";
        } else {
            if (userPasswordFromMySQL.equals(userPassword)) {
                return "true";
            } else {
                return "password incorrect";
            }

        }
    }


    @RequestMapping("/register")
    @ResponseBody
    public String addItem(@RequestParam("userEmail") String userEmail, @RequestParam("userPassword") String userPassword
    ) {
        String whetherEmailExist = userRepo.getItem(userEmail);
        if (whetherEmailExist.equals("email dos not exist")) {
            if (userRepo.addItem(userEmail, userPassword) >= 1) {
                return "true";
            } else {
                return "System wrong!";
            }
        }
        return "Email already exists";
    }


/*
@RequestMapping("/deteteUser")
    @ResponseBody
    public String deteteItem(@RequestParam("userEmail") String userEmail) {
        if (userRepo.deleteItem(userEmail) >= 1) {
            return "User Deleted Successfully";
        } else {
            return "Something went wrong !";
        }
    }
 */

}
