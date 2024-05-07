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

import java.util.Date;
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

    public PostsDTO findByTitle(String title){
        List<Post> posts = postRepository.findByTitleContainingIgnoreCase(title);
        if(posts.isEmpty()){
            throw new ObjectNotFoundException("Não existe post com esse título");
        }
        PostsDTO postsDTO = new PostsDTO(posts);

        return postsDTO;
    }

    public PostsDTO findByAuthor(String name){
        List<Post> posts = postRepository.searchByOwnerName(name);

        if(posts.isEmpty()){
            throw new ObjectNotFoundException("Autor não existe ou não tem posts");
        }
        return new PostsDTO(posts);
    }
    public PostsDTO fyndPostsBetweenDates(String query, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        List<Post> posts = postRepository.findBetweenDates(query, minDate, maxDate);

        if(posts.isEmpty()){
            throw new ObjectNotFoundException("Sem posts entre as datas especificadas");
        }

        return new PostsDTO(posts);
    }

}
