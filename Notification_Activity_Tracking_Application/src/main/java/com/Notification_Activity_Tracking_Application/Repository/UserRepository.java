package com.Notification_Activity_Tracking_Application.Repository;

import com.Notification_Activity_Tracking_Application.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
