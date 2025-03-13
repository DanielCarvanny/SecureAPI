package tech.buildrun.springsecurity.entity;

import jakarta.persistence.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import tech.buildrun.springsecurity.controller.dto.LoginRequest;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @Column(unique = true, name = "username")
    private String username;

    private String password;

    public User() {
    }

    public User(UUID userId, Set<Role> roles, String username, String password) {
        this.userId = userId;
        this.roles = roles;
        this.username = username;
        this.password = password;
    }

     public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoginCorrect(LoginRequest loginRequest, PasswordEncoder passwordEncoder) {
         return passwordEncoder.matches(loginRequest.password(), this.password);

    }
}
