package com.mongoproject.compassmongo.services;

import com.mongoproject.compassmongo.domain.User;
import com.mongoproject.compassmongo.dto.UserDTO;
import com.mongoproject.compassmongo.repositories.UserRepository;
import com.mongoproject.compassmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        var users = userRepository.findAll();
        List<UserDTO> dtos = users.stream().map(user -> new UserDTO(user.getName(), user.getEmail())).toList();
        return dtos;
    }

    public UserDTO findById(String id){
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            UserDTO dto = new UserDTO(user.get().getName(), user.get().getEmail());
            return dto;
        }
        throw new ObjectNotFoundException("Objeto não encontrado");
    }

    public User insert(UserDTO dto){
        User newUser = new User(dto.name(), dto.email());

        return userRepository.insert(newUser);
    }

    public void deleteUser(String id){
        findById(id);
        userRepository.deleteById(id);
    }
}
