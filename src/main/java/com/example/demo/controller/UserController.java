package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RequestMapping("api/v1/user")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @GetMapping("/getUserByID/{id}")
    public User getUserByID(@PathVariable(value = "id") Long userID) throws UserNotFoundException {
        return userRepo.findById(userID)
                .orElseThrow(() -> new UserNotFoundException(userID));
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable(value = "id") Long userID, @RequestBody User userDetails) throws UserNotFoundException {
        User user = userRepo.findById(userID)
                .orElseThrow(() -> new UserNotFoundException(userID));

        user.setFullName(userDetails.getFullName());
        user.setEmail(userDetails.getEmail());
        user.setDepartment(userDetails.getDepartment());
        user.setUserRank(userDetails.getUserRank());

        return userRepo.save(user);
    }

    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userID) throws UserNotFoundException {
        User user = userRepo.findById(userID)
                .orElseThrow(() -> new UserNotFoundException(userID));

        userRepo.delete(user);

        return ResponseEntity.ok().build();
    }

}

