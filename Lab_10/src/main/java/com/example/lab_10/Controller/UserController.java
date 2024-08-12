package com.example.lab_10.Controller;

import com.example.lab_10.Api.ApiResponse;
import com.example.lab_10.Model.User;
import com.example.lab_10.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUser() {
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(Integer id,@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        if (userService.updateUser(id, user)) {
            return ResponseEntity.status(200).body(new ApiResponse("User updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("User Not Found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(Integer id) {
        if (userService.deleteUser(id)) {
            return ResponseEntity.status(200).body(new ApiResponse("User deleted successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("User Not Found"));
    }
}
