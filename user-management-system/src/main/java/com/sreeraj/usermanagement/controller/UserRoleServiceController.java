package com.sreeraj.usermanagement.controller;

import com.sreeraj.usermanagement.model.Role;
import com.sreeraj.usermanagement.model.User;
import com.sreeraj.usermanagement.model.UserRole;
import com.sreeraj.usermanagement.repository.RoleRepository;
import com.sreeraj.usermanagement.repository.UserRepository;
import com.sreeraj.usermanagement.repository.UserRoleRepository;
import com.sreeraj.usermanagement.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/userroles")
public class UserRoleServiceController {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public List<UserRole> getAllUserRoles() {
        return userRoleService.getAllUserRoles();
    }

    @GetMapping("/{id}")
    public Optional<UserRole> getUserRoleById(@PathVariable String id) {
        return userRoleService.getUserRoleByid(id); // id should be String
    }

    @PostMapping
    public ResponseEntity<String> saveUserRole(@RequestBody Map<String, Object> requestData) {
        try {
            int userId = Integer.parseInt(requestData.get("user_id").toString());
            String roleId = requestData.get("role_id").toString();

            // Fetch User and Role
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
            Role role = roleRepository.findById(roleId)
                    .orElseThrow(() -> new IllegalArgumentException("Role not found with ID: " + roleId));

            // Create and save UserRole
            UserRole userRole = new UserRole();
            userRole.setUser(user);
            userRole.setRole(role);
            userRoleRepository.save(userRole);

            return ResponseEntity.ok("UserRole saved successfully");
        } catch (IllegalArgumentException e) {
            // Return a meaningful error message
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            // Handle unexpected errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUserRole(@PathVariable String id) {
        userRoleService.deleteURsById(id); // id should be String
    }
}
