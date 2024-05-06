package com.mongoproject.compassmongo.services;

import com.mongoproject.compassmongo.domain.Post;
import com.mongoproject.compassmongo.domain.User;
import com.mongoproject.compassmongo.dto.PostDTO;
import com.mongoproject.compassmongo.dto.PostsDTO;
import com.mongoproject.compassmongo.dto.UserDTO;
import com.mongoproject.compassmongo.repositories.PostRepository;
import com.mongoproject.compassmongo.repositories.UserRepository;
import com.mongoproject.compassmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDTO findById(String id){
        Optional<Post> post = postRepository.findById(id);

        if(post.isPresent()){
            PostDTO dto = new PostDTO(post.get());
            return dto;
        }
        throw new ObjectNotFoundException("Objeto não encontrado");
    }


}
