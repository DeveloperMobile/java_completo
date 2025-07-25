package com.developermobile.workshopmongo.config;

import com.developermobile.workshopmongo.repository.UserRepository;
import com.developermobile.workshopmongo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        repository.deleteAll();
        repository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
