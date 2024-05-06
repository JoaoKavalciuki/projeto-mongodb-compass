package com.mongoproject.compassmongo.repositories;

import com.mongoproject.compassmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
