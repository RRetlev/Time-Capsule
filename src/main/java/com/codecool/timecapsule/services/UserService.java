package com.codecool.timecapsule.services;

import com.codecool.timecapsule.model.UserInformation;
import com.codecool.timecapsule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserInformation> findAllUsers() {
    return userRepository.findAll();
    }

    public List<UserInformation> findUsersWithoutCapsule() {
    return null;
    }
}
