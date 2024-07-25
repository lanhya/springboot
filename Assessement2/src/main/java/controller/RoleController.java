package controller;

import entity.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/role")
public class RoleController {
    public static ArrayList<Role> roles = new ArrayList<>();
    //-----Add Role-----
    @PostMapping("/add")
    public ResponseEntity<String> addRole(Role role) {
        roles.add(role);
        return ResponseEntity.ok("Add role success!");
    }

    //-----Update Role-----
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateRole(@PathVariable String id, Role role) {
        for (Role r: roles) {
            if (Objects.equals(r.getId(), r.getId())) {
                r.setName(role.getName());
                r.setStatus(role.getStatus());
            }
        }
        return ResponseEntity.ok("Updated role success!");
    }

    //-----Delete Role-----
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id) {
        for (Role r: roles) {
            if (Objects.equals(r.getId(), id)) {
                roles.remove(r);
            }
        }
        return ResponseEntity.ok("Delete role success!");
    }

    //-----Update Role By Id-----
    @GetMapping("/{id}")
    public ResponseEntity<Role> findRoleById(@RequestParam Long id) {
        Role role = new Role();
        for (Role r: roles) {
            if (Objects.equals(r.getId(), id)) {
                role = r;
            }
        }
        return ResponseEntity.ok(role);
    }

    //-----Find Role By roleName
    @GetMapping("/roleName")
    public ResponseEntity<Role> findRoleByRoleName(@RequestParam String roleName) {
        Role role = new Role();
        for (Role r: roles) {
            if (Objects.equals(r.getName(), roleName)) {
                role = r;
            }
        }
        return ResponseEntity.ok(role);
    }

    //-----Find All Roles-----
    @GetMapping("/all")
    public ResponseEntity<List<Role>> findAllRoles(@RequestParam String param) {
        return ResponseEntity.ok(roles);
    }

}
