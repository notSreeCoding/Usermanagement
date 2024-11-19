package com.sreeraj.usermanagement.service;

import com.sreeraj.usermanagement.model.Role;
import com.sreeraj.usermanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(String id){
        return roleRepository.findById(id);
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }

    public void deleteRoleById(String id){
        roleRepository.deleteById(id);
    }
}
