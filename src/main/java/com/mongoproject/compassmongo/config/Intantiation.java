package com.mongoproject.compassmongo.config;

import com.mongoproject.compassmongo.domain.Post;
import com.mongoproject.compassmongo.domain.User;
import com.mongoproject.compassmongo.dto.AuthorDTO;
import com.mongoproject.compassmongo.repositories.PostRepository;
import com.mongoproject.compassmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

import java.util.Arrays;

@Configuration
public class Intantiation implements CommandLineRunner {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    private UserRepository userRepository;
    private PostRepository postRepository;

    @Autowired
    public Intantiation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User alex = new User("Alex", "alex@gmail.com");
        User charles = new User("Charles", "charles@gmail.com");
        User mary = new User("Mary", "mary@gmail.com");
        userRepository.saveAll(Arrays.asList(alex, charles, mary));

        Post post = new Post(new AuthorDTO(mary.getId(), mary.getName()), format.parse("21/01/2024"), "Começando na UFRJ", "Hoje começo minha graduação na UFRJ");
        Post post2 = new Post(new AuthorDTO(mary.getId(), mary.getName()), format.parse("21/06/2024"), "Partiu ferias", "Partiu para Jericoacara");
        Post post3 = new Post(new AuthorDTO(charles.getId(), charles.getName()), format.parse("21/06/2024"), "Formei", "Hoje me formei na fatec");

        postRepository.deleteAll();
        postRepository.saveAll(Arrays.asList(post, post2, post3));

        mary.getPosts().addAll(Arrays.asList(post, post2));
        charles.getPosts().add(post3);
        userRepository.saveAll(Arrays.asList(mary, charles));

    }
}
