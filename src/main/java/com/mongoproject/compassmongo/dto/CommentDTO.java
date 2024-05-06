package com.mongoproject.compassmongo.dto;

import java.io.Serializable;
import java.util.Date;

public record CommentDTO(String text, Date date, AuthorDTO authorDTO) implements Serializable {
}
