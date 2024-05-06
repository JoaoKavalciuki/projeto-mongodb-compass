package com.mongoproject.compassmongo.dto;

import java.io.Serializable;

public record UserDTO (String name, String email) implements Serializable {
}
