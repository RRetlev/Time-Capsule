package com.codecool.timecapsule.controller;

import com.codecool.timecapsule.model.OneuseURL;
import com.codecool.timecapsule.services.URLService;
import com.codecool.timecapsule.services.UrlNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class URLController {
    @Autowired
    private URLService urlService;

    @GetMapping("/{inviteId}")
    public void entry(@PathVariable String inviteId) throws UrlNotExistsException {
        urlService.useURL(inviteId);
        //TODO logic test
    }
    @GetMapping("/invite")
    public List<OneuseURL> inviteUser(@RequestParam List<String> emails ){
        return urlService.createURLs(emails);
        //TODO test
    }
}
