package com.codecool.timecapsule.services;

import com.codecool.timecapsule.model.OneuseURL;
import com.codecool.timecapsule.repository.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;


@Component
public class URLService {
    @Autowired
    private URLRepository urlRepository;

    private String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();

    private Random random = new Random();

    public void useURL(String inviteId) throws UrlNotExistsException {
        Optional<OneuseURL> url = urlRepository.getOneuseURLByURL(inviteId);
        url.orElseThrow(() -> new UrlNotExistsException(inviteId));
        urlRepository.delete(url.get());
    }

    public List<OneuseURL> createURLs(List<String> emails) {
        return urlRepository.saveAll(emails.stream().map(email -> new OneuseURL(generateUniqueURLs(), email)).collect(Collectors.toList()));
        //TODO tests
    }

    private UUID generateUniqueURLs() {
        return UUID.randomUUID();
        //TODO tests Springuuid
    }
}
