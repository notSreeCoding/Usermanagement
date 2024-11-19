package com.sreeraj.usermanagement.controller;

import com.sreeraj.usermanagement.model.Role;
import com.sreeraj.usermanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleServiceController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Optional<Role> getRoleById(@PathVariable String id){
        return roleService.getRoleById(id);
    }

    @PostMapping
    public Role saveRole(@RequestBody Role role){
        return roleService.saveRole(role);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable String id){
        roleService.deleteRoleById(id);
    }
}
