package br.com.leobarreto.userapi;

import br.com.leobarreto.userapi.domain.User;
import br.com.leobarreto.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UserApiApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(UserApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.saveAll(
                List.of(new User(null, "User 1", "user1@email.com", "12345", 20.0),
                        new User(null, "User 2", "user2@email.com", "12345", 24.0),
                        new User(null, "User 3", "user3@email.com", "12345", 13.0)
                )
        );
    }
}
