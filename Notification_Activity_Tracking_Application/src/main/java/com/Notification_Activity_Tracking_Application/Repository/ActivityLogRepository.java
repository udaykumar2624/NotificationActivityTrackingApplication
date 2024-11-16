package com.Notification_Activity_Tracking_Application.Repository;

import com.Notification_Activity_Tracking_Application.Entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog,Long> {
    List<ActivityLog> findByUserId(Long userId);
}
