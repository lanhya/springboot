package com.example.javaframeworkassessement1.controller;

import com.example.javaframeworkassessement1.entity.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/role")
public class RoleController {

    public static ArrayList<Role> roles = new ArrayList<>();

    // ------------------------Add Role--------------------------------
    @PostMapping("/add-role")
    public ResponseEntity<String> postMethodName(@RequestBody Role role) {
        roles.add(role);
        return ResponseEntity.ok("Add role success!");

    }

    // ------------------------Update Role--------------------------------
    @PutMapping("update-role/{id}")
    public ResponseEntity updateRole(@PathVariable String id, @RequestBody Role role) {
        for (Role r : roles) {
            if (Objects.equals(r.getId(), role.getId())) {
                r.setRoleName(role.getRoleName());
                r.setDescription(role.getDescription());
            }
        }
        return ResponseEntity.ok("Updated role success!");
    }

    // ------------------------Delete Role--------------------------------
    @DeleteMapping("delete-role/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id) {
        for (Role r : roles) {
            if (Objects.equals(r.getId(), id)) {
                roles.remove(r);
            }
        }
        return ResponseEntity.ok("Deleted role success!");
    }

    // ------------------------Search Role By ID--------------------------------
    @GetMapping("/find-one/role/{id}")
    public ResponseEntity<Role> findRoleById(@PathVariable Long id) {
        Role role = new Role();
        for (Role r : roles) {
            if (Objects.equals(r.getId(), id)) {
                role = r;
            }
        }
        return ResponseEntity.ok(role);
    }

    // ------------------------Search Role By ID--------------------------------
    @GetMapping("/fine-one/roleName")
    public ResponseEntity<Role> findRoleByParam(@RequestParam Long id) {
        Role role = new Role();
        for (Role r : roles) {
            if (Objects.equals(r.getId(), id)) {
                role = r;
            }
        }
        return ResponseEntity.ok(role);
    }

    // ------------------------Search All Roles--------------------------------
    @GetMapping("/find-all-role")
    public ResponseEntity<List<Role>> findAllRoles(@RequestParam String param) {
        return ResponseEntity.ok(roles);
    }

}
