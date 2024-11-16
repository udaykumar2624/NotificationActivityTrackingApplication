package com.Notification_Activity_Tracking_Application.service;

import com.Notification_Activity_Tracking_Application.Dto.ActivityLogRequestDTO;
import com.Notification_Activity_Tracking_Application.Entity.ActivityLog;

import java.util.List;


public interface ActivityLogService {

    ActivityLogRequestDTO createActivityLog(long userId, ActivityLogRequestDTO activityLogRequestDTO);

    List<ActivityLog> getActivityLogsForUser(Long userId);

//    List<ActivityLogRequestDTO>getActivityLogsForUser(long userId);
//
//    void logActivity(Long userId);

}
