package com.codecool.timecapsule.controller;

import com.codecool.timecapsule.model.Message;
import com.codecool.timecapsule.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class MessageController {

    @Autowired
    private MessageService messageService;

//    @GetMapping("/messages")
//    public List<Message> getMessages(){
//        return messageService.getAllMessages();
//    }

    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message){
        return messageService.addMessage(message);
    }


}
