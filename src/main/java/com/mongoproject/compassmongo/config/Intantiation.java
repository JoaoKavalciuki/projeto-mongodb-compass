package com.mongoproject.compassmongo.config;

import com.mongoproject.compassmongo.domain.User;
import com.mongoproject.compassmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Intantiation implements CommandLineRunner {

    private UserRepository userRepository;

    @Autowired
    public Intantiation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User alex = new User("Alex", "alex@gmail.com");
        User charles = new User("Charles", "charles@gmail.com");
        User mary = new User("Mary", "mary@gmail.com");

        userRepository.saveAll(Arrays.asList(alex, charles, mary));
    }
}
