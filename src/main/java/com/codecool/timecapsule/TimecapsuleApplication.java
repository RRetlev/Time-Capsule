package com.codecool.timecapsule;

import com.codecool.timecapsule.model.Email;
import com.codecool.timecapsule.model.Message;
import com.codecool.timecapsule.model.MessageEmail;
import com.codecool.timecapsule.model.UserInformation;
import com.codecool.timecapsule.repository.MessageRepository;
import com.codecool.timecapsule.repository.UserRepository;
import com.codecool.timecapsule.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableScheduling
public class TimecapsuleApplication {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    public static void main(String[] args) {
        SpringApplication.run(TimecapsuleApplication.class, args);
    }

    /* cron is a  date format as follows second/minute/hour/day/year
      "*" means all "?" means any  */
    @Scheduled(cron = "0 56 * * * ?")
    public void sendEmails(){
        emailService.sendEmail(messageRepository.getExpiredCapsules().stream().map(capsule -> new MessageEmail(capsule.getMessage(),capsule.getEmail())).collect(Collectors.toList()));
    }


    @Bean
    public CommandLineRunner init(){
        return args -> {
            UserInformation user1 = UserInformation.builder()
                    .email("whatever@whatever.com")
                    .username("Dumbó")
                    .id(1)
                    .build();
            UserInformation user2 = UserInformation.builder()
                    .email("whoknows@whoknows.com")
                    .username("Marvin")
                    .id(2)
                    .build();


            Message message = Message.builder()
                    .message("First Message")
                    .creationDate(LocalDate.now())
                    .email(user2.getEmail())
                    .build();

            userRepository.save(user1);
            userRepository.save(user2);
            messageRepository.save(message);
        };
    }

}
