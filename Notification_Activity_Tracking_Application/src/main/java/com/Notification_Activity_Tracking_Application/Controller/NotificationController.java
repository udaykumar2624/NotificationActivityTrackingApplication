package com.Notification_Activity_Tracking_Application.Controller;

import com.Notification_Activity_Tracking_Application.Dto.NotificationDTO;
import com.Notification_Activity_Tracking_Application.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class NotificationController {
@Autowired
    private NotificationService notificationService;


    /* //localhost:8081/api/user/2/notifications */  // hit these url to create notification  with the id

    @PostMapping("/user/{userId}/notifications")
    public ResponseEntity<NotificationDTO> createNotification(@PathVariable (value = "userId") long userId,@RequestBody NotificationDTO notificationDTO){
        return  new ResponseEntity<>(notificationService.createNotification(userId,notificationDTO), HttpStatus.CREATED);
    }

    /* //localhost:8081/api/user/1/notifications  */  // hit these url to getNotificationsByUserId notification  with the id
    @GetMapping("/user/{userId}/notifications")
    public List<NotificationDTO> getNotificationsByUserId(@PathVariable(value = "userId") long userId){
        return notificationService.getNotificationByUserId(userId);
    }

     /* // localhost:8081/api/mark-read?userId=1 */   // hit these url to markNotificationsAsRead notification  with the id

    @PostMapping("/mark-read")
    public ResponseEntity<String> markNotificationsAsRead(@RequestParam Long userId) {
        notificationService.markNotificationsAsRead(userId);
        return ResponseEntity.ok("Notifications marked as read.");
    }



}
