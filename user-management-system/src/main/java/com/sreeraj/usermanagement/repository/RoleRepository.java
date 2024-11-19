package com.sreeraj.usermanagement.repository;

import com.sreeraj.usermanagement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RoleRepository extends JpaRepository<Role, String> {


}
