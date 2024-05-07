package com.mongoproject.compassmongo.repositories;

import com.mongoproject.compassmongo.domain.Post;
import com.mongoproject.compassmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{'author':  {$regex:  ?0, $options: 'i'}}")
    List<Post> searchByOwnerName(String name);
    List<Post> findByTitleContainingIgnoreCase(String title);
}
