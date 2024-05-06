package com.mongoproject.compassmongo.repositories;

import com.mongoproject.compassmongo.domain.Post;
import com.mongoproject.compassmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
