package com.Notification_Activity_Tracking_Application.service.impl;

import com.Notification_Activity_Tracking_Application.Dto.ActivityLogRequestDTO;
import com.Notification_Activity_Tracking_Application.Dto.NotificationDTO;
import com.Notification_Activity_Tracking_Application.Entity.ActivityLog;
import com.Notification_Activity_Tracking_Application.Entity.Notification;
import com.Notification_Activity_Tracking_Application.Entity.User;
import com.Notification_Activity_Tracking_Application.Repository.ActivityLogRepository;
import com.Notification_Activity_Tracking_Application.Repository.UserRepository;
import com.Notification_Activity_Tracking_Application.payload.ResourceNotFoundException;
import com.Notification_Activity_Tracking_Application.service.ActivityLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {
    private ActivityLogRepository activityLogRepository;
    private UserRepository userRepository;

    public ActivityLogServiceImpl(ActivityLogRepository activityLogRepository, UserRepository userRepository) {
        this.activityLogRepository = activityLogRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ActivityLogRequestDTO createActivityLog(long userId, ActivityLogRequestDTO activityLogRequestDTO) {

        // Convert Dto to Entity
        ActivityLog activityLog = mapToEntity(activityLogRequestDTO);
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        activityLog.setUser(user);

        ActivityLog newActivityLog = activityLogRepository.save(activityLog);

        // Convert Entity to Dto
        ActivityLogRequestDTO postResponse = mapToDto(newActivityLog);
        return postResponse;
    }

    @Override
    public List<ActivityLog> getActivityLogsForUser(Long userId) {
        return activityLogRepository.findByUserId(userId);
    }


    // Convert Entity into Dto

    private ActivityLogRequestDTO mapToDto(ActivityLog activityLog){
        ActivityLogRequestDTO   activityLogRequestDTO =new ActivityLogRequestDTO();
        activityLogRequestDTO.setId(activityLog.getId());
        activityLogRequestDTO.setActivityType(activityLog.getActivityType());
        activityLogRequestDTO.setDescription(activityLog.getDescription());
        activityLogRequestDTO.setIpAddress(activityLog.getIpAddress());
        activityLogRequestDTO.setTimestamp(activityLog.getTimestamp());


        return activityLogRequestDTO;
    }

    // convert DTO to Entity

    private  ActivityLog mapToEntity(ActivityLogRequestDTO activityLogRequestDTO) {
        ActivityLog activityLog = new ActivityLog();
        activityLog.setId(activityLogRequestDTO.getId());
        activityLog.setActivityType(activityLogRequestDTO.getActivityType());
        activityLog.setDescription(activityLogRequestDTO.getDescription());
        activityLog.setIpAddress(activityLogRequestDTO.getIpAddress());
        activityLog.setTimestamp(activityLogRequestDTO.getTimestamp());

        return activityLog;
    }
}








