package controller;

import entity.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user")

public class UserController {
    public static ArrayList<Users> usersList = new ArrayList<>();
    // ----------Add User---------
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody Users user){
        usersList.add(user);
        return ResponseEntity.ok("Add user success!");
    }

    // ----------update User---------
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(Users users) {
        for (Users u: usersList) {
            if (Objects.equals(u.getId(), users.getId())) {
                u.setUser_name(users.getUser_name());
                u.setPassword(users.getPassword());
                u.setEmail(users.getEmail());
                u.setGender(users.getGender());
                u.setStatus(users.getStatus());
            }
        }
        return ResponseEntity.ok("Updated user success!");
    }

    // ----------delete User---------
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        for (Users u: usersList) {
            if (Objects.equals(u.getId(), id)) {
                usersList.remove(u);
            }
        }
        return ResponseEntity.ok("Delete user success!");
    }

    // ----------Find User By  Id---------

    @GetMapping("/{id}")
    public ResponseEntity<Users> findById(@PathVariable Long id) {
        Users users = new Users();
        for (Users u: usersList) {
            if (Objects.equals(u.getId(), id)) {
                users = u;
            }
        }
        return ResponseEntity.ok(users);
    }

    // ----------Find all Users---------
    @GetMapping("/all")
    public ResponseEntity<List<Users>> findAllUsers() {
        return ResponseEntity.ok(usersList);
    }
}
