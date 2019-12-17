package com.codecool.timecapsule.controller;

import com.codecool.timecapsule.model.UserInformation;
import com.codecool.timecapsule.services.EmailService;
import com.codecool.timecapsule.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService ;
//    @Autowired
//    private EmailService emailService;

    @GetMapping("/all")
    public List<UserInformation> getAllUsers(){
        //emailService.sendEmail();
        return userService.findAllUsers();
        //TODO tests
    }

    @GetMapping("/without")
    public List<UserInformation> getAllUserWithoutActiveCapsule(){
        return userService.findUsersWithoutCapsule();
        //TODO tests / SQL
    }

}
