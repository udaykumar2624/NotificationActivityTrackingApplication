package com.Notification_Activity_Tracking_Application.Repository;

import com.Notification_Activity_Tracking_Application.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {

    List<Notification> findByUserId(long userId);
}
