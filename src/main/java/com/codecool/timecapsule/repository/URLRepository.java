package com.codecool.timecapsule.repository;

import com.codecool.timecapsule.model.OneuseURL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface URLRepository extends JpaRepository<OneuseURL,String> {

    Optional<OneuseURL> getOneuseURLByURL(String URL);
}
