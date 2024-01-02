package tech.burny.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "security_role")
public class SecurityRole {
    @Id
    private Long id;

    private String name;

    private String key;

    private Integer sort;

    private Long pid;
}
