package com.sreeraj.usermanagement.service;

import com.sreeraj.usermanagement.model.UserRole;
import com.sreeraj.usermanagement.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<UserRole> getAllUserRoles(){
        return userRoleRepository.findAll();
    }

    public Optional<UserRole> getUserRoleByid(String id){
        return userRoleRepository.findById(id);
    }

    public UserRole saveUserRole(UserRole userRole){
        return userRoleRepository.save(userRole);
    }

    public void deleteURsById(String id){
        userRoleRepository.deleteById(id);
    }
}
