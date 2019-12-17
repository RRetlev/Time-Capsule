package com.codecool.timecapsule;

import com.codecool.timecapsule.model.Message;
import com.codecool.timecapsule.model.UserInformation;
import com.codecool.timecapsule.repository.MessageRepository;
import com.codecool.timecapsule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;

@SpringBootApplication
@EnableScheduling
public class TimecapsuleApplication {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(TimecapsuleApplication.class, args);
    }
    @Bean
    public CommandLineRunner init(){
        return args -> {
            UserInformation user1 = UserInformation.builder()
                    .email("whatever@whatever.com")
                    .psw(68464l)
                    .username("Dumbó")
                    .id(1)
                    .build();
            UserInformation user2 = UserInformation.builder()
                    .email("whoknows@whoknows.com")
                    .psw(44444l)
                    .username("Marvin")
                    .id(2)
                    .build();


            Message message = Message.builder()
                    .message("faszom")
                    .creationDate(LocalDate.now())
                    .email(user2.getEmail())
                    .build();

            userRepository.save(user1);
            userRepository.save(user2);
            messageRepository.save(message);
        };
    }

}
