package com.codecool.timecapsule.repository;

import com.codecool.timecapsule.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {

    @Query(value = "SELECT * FROM MESSAGE WHERE  MESSAGE.ENDING_DATE = CURRENT_DATE",nativeQuery = true)
    List<Message> getExpiredCapsules();
}
