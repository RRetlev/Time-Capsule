package com.codecool.timecapsule.repository;

import com.codecool.timecapsule.model.OneuseURL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface URLRepository extends JpaRepository<OneuseURL,String> {

    Optional<OneuseURL> getOneuseURLByURL(UUID URL);
}
