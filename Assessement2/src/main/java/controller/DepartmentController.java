package controller;

import entity.Department;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    public static ArrayList<Department> departments = new ArrayList<>();
    //-----Add Department----
    @PostMapping("/add")
    public ResponseEntity<String> addDepartment(@RequestBody Department department) {
        departments.add(department);
        return ResponseEntity.ok("Add department success.");
    }

    //-----Update Department-----
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        for (Department d: departments) {
            if (Objects.equals(d.getId(), department.getId())) {
                d.setName(department.getName());
                d.setStatus(department.getStatus());
            }
        }
        return ResponseEntity.ok("Updated department success.");
    }

    //-----Delete Department-----
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        for (Department d: departments) {
            if (Objects.equals(d.getId(), id)) {
                departments.remove(d);
            }
        }
        return ResponseEntity.ok("Deleted department success.");
    }

    //-----Find Department by Id-----
    @GetMapping("/{id}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable Long id) {
        Department department = new Department();
        for (Department d: departments) {
            if (Objects.equals(d.getId(), id)) {
                department = d;
            }
        }
        return ResponseEntity.ok(department);
    }

    //-----Find All Department-----
    @GetMapping("/all")
    public ResponseEntity<List<Department>> findAllDepartments(@RequestParam String param) {
        return ResponseEntity.ok(departments);
    }

}
