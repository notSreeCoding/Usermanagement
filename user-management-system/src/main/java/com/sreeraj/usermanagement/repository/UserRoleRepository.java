package com.sreeraj.usermanagement.repository;

import com.sreeraj.usermanagement.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole,String> {
}
