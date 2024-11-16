package com.Notification_Activity_Tracking_Application.service.impl;

import com.Notification_Activity_Tracking_Application.Dto.UserDTO;
import com.Notification_Activity_Tracking_Application.Entity.User;
import com.Notification_Activity_Tracking_Application.Repository.UserRepository;
import com.Notification_Activity_Tracking_Application.payload.ResourceNotFoundException;
import com.Notification_Activity_Tracking_Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
            // Convert Dto to Entity
        User user = mapToEntity(userDTO);
        User newUser = userRepository.save(user);

        // Convert Entity to Dto
        UserDTO postResponse = mapToDto(newUser);
        return postResponse;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> mapToDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return mapToDto(user);

    }


    // Convert Entity into Dto

    private UserDTO mapToDto(User user){
        UserDTO userDTO =new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setUpdatedAt(user.getUpdatedAt());
        return userDTO;
    }

    // convert DTO to Entity

    private  User mapToEntity(UserDTO userDTO){
        User user =new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setCreatedAt(userDTO.getCreatedAt());
        user.setUpdatedAt(userDTO.getUpdatedAt());
        return user;
    }


}
