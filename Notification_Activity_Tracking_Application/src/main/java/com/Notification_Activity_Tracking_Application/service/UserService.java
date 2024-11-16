package com.Notification_Activity_Tracking_Application.service;

import com.Notification_Activity_Tracking_Application.Dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);
}
