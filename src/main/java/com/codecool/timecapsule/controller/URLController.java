package com.codecool.timecapsule.controller;

import com.codecool.timecapsule.model.Email;
import com.codecool.timecapsule.model.InviteEmail;
import com.codecool.timecapsule.model.OneuseURL;
import com.codecool.timecapsule.model.StringResponse;
import com.codecool.timecapsule.services.EmailService;
import com.codecool.timecapsule.services.URLService;
import com.codecool.timecapsule.services.UrlNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class URLController {
    @Autowired
    private URLService urlService;
    
    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/{inviteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public StringResponse entry(@PathVariable UUID inviteId){
        try{
             return StringResponse.builder()
                     .response(urlService.useURL(inviteId))
                     .build();
        }catch(UrlNotExistsException e){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"You dont have an active link to use",e);
        }
        //TODO logic test
    }
    @PostMapping("/invite")
    public List<OneuseURL> inviteUser(@RequestBody List<String> emails ){
        List<OneuseURL> urlEmailPairs = urlService.createURLs(emails);
        emailService.sendEmail(urlEmailPairs.stream().map(pair -> new InviteEmail(pair.getURL().toString(),pair.getEmail())).collect(Collectors.toList()));
        return urlEmailPairs;
        //TODO test refactor this abomination
    }
}
