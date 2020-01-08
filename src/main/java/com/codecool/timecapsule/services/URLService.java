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

    public String useURL(UUID inviteId) throws UrlNotExistsException {
        Optional<OneuseURL> url = urlRepository.getOneuseURLByURL(inviteId);
        url.orElseThrow(() -> new UrlNotExistsException(inviteId.toString()));
        System.out.println("UUID found");
        //urlRepository.delete(url.get());
        return url.get().getEmail();
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
