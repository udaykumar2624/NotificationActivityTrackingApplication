package com.Notification_Activity_Tracking_Application.service.impl;

import com.Notification_Activity_Tracking_Application.Dto.NotificationDTO;
import com.Notification_Activity_Tracking_Application.Dto.UserDTO;
import com.Notification_Activity_Tracking_Application.Entity.Notification;
import com.Notification_Activity_Tracking_Application.Entity.User;
import com.Notification_Activity_Tracking_Application.Repository.NotificationRepository;
import com.Notification_Activity_Tracking_Application.Repository.UserRepository;
import com.Notification_Activity_Tracking_Application.payload.ResourceNotFoundException;
import com.Notification_Activity_Tracking_Application.service.NotificationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    private NotificationRepository notificationRepository;
    private UserRepository userRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public NotificationDTO createNotification( long userId,NotificationDTO notificationDTO) {

        // Convert Dto to Entity
        Notification notification = mapToEntity(notificationDTO);
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        notification.setUser(user);

        Notification newNotification = notificationRepository.save(notification);

        // Convert Entity to Dto
        NotificationDTO postResponse = mapToDto(newNotification);
        return postResponse;


    }

    @Override
    public List<NotificationDTO> getNotificationByUserId(long userId) {

        // Retrieve Comment by UserId
        List<Notification> notifications = notificationRepository.findByUserId(userId);

        //Convert list of Notification entities to list of Notification Dto's
        return  notifications.stream().map(notification -> mapToDto(notification)).collect(Collectors.toList());


    }

    @Override
    public void markNotificationsAsRead(Long userId) {
        List<Notification> notifications = notificationRepository.findByUserId(userId);
        notifications.forEach(notification -> notification.setIsRead(true));
        notificationRepository.saveAll(notifications);

    }


    // Convert Entity into Dto

    private NotificationDTO mapToDto(Notification notification){
        NotificationDTO  notificationDTO =new NotificationDTO();
        notificationDTO.setId(notification.getId());
        notificationDTO.setType(notification.getType());
        notificationDTO.setContent(notification.getContent());
        notificationDTO.setCreatedAt(notification.getCreatedAt());
        notificationDTO.setIsRead(notification.getIsRead());
        return notificationDTO;
    }

    // convert DTO to Entity

    private  Notification mapToEntity(NotificationDTO notificationDTO){
        Notification notification =new Notification();
        notification.setId(notificationDTO.getId());
        notification.setType(notificationDTO.getType());
        notification.setContent(notificationDTO.getContent());
        notification.setCreatedAt(notificationDTO.getCreatedAt());
        notification.setIsRead(notificationDTO.getIsRead());
        return notification;
    }
}
