package tech.burny.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "security_user")
public class SecurityUser {
    @Id
    private Long id;

    private String username;

}
