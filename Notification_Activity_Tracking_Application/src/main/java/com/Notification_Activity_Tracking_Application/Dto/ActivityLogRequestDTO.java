package com.Notification_Activity_Tracking_Application.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ActivityLogRequestDTO {

    private Long Id;
    private String activityType;
    private String description;
    private String ipAddress;
    private LocalDateTime timestamp;
}
