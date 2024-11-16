package com.Notification_Activity_Tracking_Application.Controller;

import com.Notification_Activity_Tracking_Application.Dto.ActivityLogRequestDTO;
import com.Notification_Activity_Tracking_Application.Entity.ActivityLog;
import com.Notification_Activity_Tracking_Application.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity")
public class ActivityLogController {

@Autowired
    private ActivityLogService activityLogService;

/* //localhost:8081/api/activity/1/activityLog */

    @PostMapping("/{userId}/activityLog")
    public ResponseEntity<ActivityLogRequestDTO> createActivityLog(@PathVariable(value = "userId") long userId,@RequestBody ActivityLogRequestDTO activityLogRequestDTO){
        return  new ResponseEntity<>(activityLogService.createActivityLog(userId,activityLogRequestDTO), HttpStatus.CREATED);
    }


    /*
     * get api with id hit url with actual id //localhost:8081/api/activity?userId=2
     */
    @GetMapping
    public ResponseEntity<List<ActivityLog>> getUserActivityLogs(@RequestParam Long userId) {
        List<ActivityLog> activityLogs = activityLogService.getActivityLogsForUser(userId);
        return ResponseEntity.ok(activityLogs);
    }

}
