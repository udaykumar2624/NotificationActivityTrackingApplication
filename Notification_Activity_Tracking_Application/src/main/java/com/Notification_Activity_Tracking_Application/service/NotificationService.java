package com.Notification_Activity_Tracking_Application.service;

import com.Notification_Activity_Tracking_Application.Dto.NotificationDTO;

import java.util.List;

public interface NotificationService {
    NotificationDTO createNotification(long userId,NotificationDTO notificationDTO);

    List<NotificationDTO> getNotificationByUserId(long userId);

    void markNotificationsAsRead(Long userId);
}
