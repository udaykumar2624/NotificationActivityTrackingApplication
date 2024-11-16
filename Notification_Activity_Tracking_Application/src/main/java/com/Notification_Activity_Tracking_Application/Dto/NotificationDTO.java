package com.Notification_Activity_Tracking_Application.Dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class NotificationDTO {
    private Long id;
    private String type;
    private String content;
    private Boolean isRead;
    private LocalDateTime createdAt;
}
