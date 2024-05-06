package com.mongoproject.compassmongo.dto;

import com.mongoproject.compassmongo.domain.Post;

import java.util.List;

public record PostsDTO(List<Post> posts) {
}
