package com.mongoproject.compassmongo.controllers;

import com.mongoproject.compassmongo.controllers.util.Util;
import com.mongoproject.compassmongo.dto.PostDTO;
import com.mongoproject.compassmongo.dto.PostsDTO;
import com.mongoproject.compassmongo.dto.UserDTO;
import com.mongoproject.compassmongo.services.PostService;
import com.mongoproject.compassmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id){
        return ResponseEntity.ok(postService.findById(id));
    }

    @GetMapping
    public ResponseEntity<PostsDTO> findByTitle(@RequestParam(name = "title", defaultValue = "") String query){
        query = Util.decodeParam(query);
        return ResponseEntity.ok(postService.findByTitle(query));
    }
    @GetMapping("/search")
    public ResponseEntity<PostsDTO> findByAuthor(@RequestParam(name = "author", defaultValue = "") String query){
        query = Util.decodeParam(query);
        return ResponseEntity.ok(postService.findByAuthor(query));
    }
    @GetMapping("/date")
    public ResponseEntity<PostsDTO> findBetweenDates(@RequestParam(name = "query", defaultValue = "") String query,
                                                     @RequestParam(name = "minDate", defaultValue = "") String minDate,
                                                     @RequestParam(name = "maxDate", defaultValue = "") String maxDate)
    {
        query = Util.decodeParam(query);
        Date min = Util.converttDate(minDate, new Date(0L));
        Date max = Util.converttDate(maxDate, new Date());
        return ResponseEntity.ok(postService.fyndPostsBetweenDates(query, min, max));
    }


}
