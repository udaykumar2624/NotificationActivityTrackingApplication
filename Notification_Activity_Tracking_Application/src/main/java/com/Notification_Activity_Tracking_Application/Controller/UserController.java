package com.Notification_Activity_Tracking_Application.Controller;

import com.Notification_Activity_Tracking_Application.Dto.UserDTO;
import com.Notification_Activity_Tracking_Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /* To createUser
	 -> localhost8080/api/users
	  * */

@PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
    }

//    /* To Get All the Users from DB jus Hit the url
//     -> localhost8080/api/users
//      * */
   @GetMapping
  public List<UserDTO> getAllUsers() {
        return  userService.getAllUsers();
  }
//
//    /* To Get Uers By Id Form  DB Just Hit the url
//     -> localhost8080/api/users/1
//
//     */
   @GetMapping("/{id}")
  public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {

    return ResponseEntity.ok(userService.getUserById(id));

   }
}
