package com.example.javaframeworkassessement1.controller;

import com.example.javaframeworkassessement1.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {
    public static ArrayList<User> users = new ArrayList<>();

    // ------------------------Add user--------------------------------
    @PostMapping("/add-user")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        users.add(user);
        return ResponseEntity.ok("Add user success!");
    }

    // ------------------------update user--------------------------------
    @PutMapping("/update-user")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        for (User c : users) {
            if (Objects.equals(c.getId(), user.getId())) {
                c.setPhoneNumber(user.getPhoneNumber());
                c.setEmail(user.getEmail());
                c.setRole(user.getRole());
                c.setCompanyArrayList(user.getCompanyArrayList());
                c.setLastName(user.getLastName());
                c.setFirstName(user.getFirstName());
            }
        }
        return ResponseEntity.ok("Updated user success!");
    }

    // ------------------------Delete user--------------------------------
    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        for (User s : users) {
            if (Objects.equals(s.getId(), id)) {
                users.remove(s);
            }
        }
        return ResponseEntity.ok("Deleted user success!");
    }

    // ------------------------Find user by path id--------------------------------
    @GetMapping("/find-one/userName/{id}")
    public ResponseEntity<User> findUserByPath(@PathVariable Long id) {
        User user = new User();
        for (User c : users) {
            if (Objects.equals(c.getId(), id)) {
                user = c;
            }
        }
        return ResponseEntity.ok(user);
    }

    // ------------------------Find user by param id--------------------------------
    @GetMapping("/find-one/userName")
    public ResponseEntity<User> findUserByParam(@RequestParam Long id) {
        User user = new User();
        for (User c : users) {
            if (Objects.equals(c.getId(), id)) {
                user = c;
            }
        }
        return ResponseEntity.ok(user);
    }

    // ------------------------Find all users--------------------------------
    @GetMapping("/find-all-users")
    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok(users);
    }
}
