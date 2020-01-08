package com.codecool.timecapsule.repository;

import com.codecool.timecapsule.model.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserInformation,Integer> {
    @Query(value = "SELECT DISTINCT ui.ID,USERNAME,ui.EMAIL FROM USER_INFORMATION ui " +
            "LEFT JOIN MESSAGE M2 on ui.EMAIL = M2.EMAIL " +
            "LEFT JOIN ONEUSEURL O on ui.EMAIL = O.EMAIL " +
            "WHERE " +
            "M2.EMAIL IS NULL " +
            "AND O.EMAIL IS NULL",nativeQuery = true)
    List<UserInformation> getUsersWithoutCapsuleAndActiveLink();

}
