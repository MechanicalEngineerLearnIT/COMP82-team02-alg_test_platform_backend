package com.example.demo.controller;


import com.example.demo.model.userinfo;
import com.example.demo.repository.userinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
controller  for  user logIN and register

 */
@RestController
public class UserInfoController {


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
    @RequestMapping(value ="/login", method = RequestMethod.POST)
    @ResponseBody
    public String getItem(@RequestParam(value="userEmail") String userEmail, @RequestParam(value="userPassword") String userPassword) {
        String userPasswordFromMySQL = userRepo.getItem(userEmail);
        if (userPasswordFromMySQL.equals("email dos not exist")) {
            return "email does not exist";
        } else {
            if (userPasswordFromMySQL.equals(userPassword)) {
                System.out.println("登陆成功！！！！！！！！！");
                return "true";
            } else {

                return "password incorrect";
            }

        }
    }


    @RequestMapping(value ="/register", method = RequestMethod.POST)
    @ResponseBody
    public String addItem(@RequestParam(value ="userEmail") String userEmail, @RequestParam(value ="userPassword") String userPassword
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
