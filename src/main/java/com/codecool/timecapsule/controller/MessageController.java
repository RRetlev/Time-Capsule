package com.codecool.timecapsule.controller;

import com.codecool.timecapsule.model.Message;
import com.codecool.timecapsule.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/messages")
    public List<Message> getmessages(){
        return messageService.getAllMessages();
    }

}
