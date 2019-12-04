package com.codecool.timecapsule.repository;

import com.codecool.timecapsule.model.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInformation,Integer> {
}
