package com.codecool.timecapsule.repository;

import com.codecool.timecapsule.model.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserInformation,Integer> {
    //TODO
    //@Query(" select ui from USER_INFORMATION u")
    //public List<UserInformation> getUsersWithoutCapsule();
}
