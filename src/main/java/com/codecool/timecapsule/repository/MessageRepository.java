package com.codecool.timecapsule.repository;

import com.codecool.timecapsule.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {
}
