package com.codecool.timecapsule.services;

import com.codecool.timecapsule.model.Message;
import com.codecool.timecapsule.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message addMessage(Message message){
        message.setCreationDate(LocalDate.now());
        return messageRepository.save(message);
    }

//    public List<Message> getMessagesNeedToBeSent(){
//        return messageRepository.getExpiredCapsules();
//    }
}
