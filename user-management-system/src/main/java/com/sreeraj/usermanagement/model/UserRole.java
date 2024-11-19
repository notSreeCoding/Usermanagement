package com.sreeraj.usermanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private int id; // Ensure this matches the DB column type (e.g., VARCHAR).

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Maps to user_id in DB
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false) // Maps to role_id in DB
    private Role role;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
