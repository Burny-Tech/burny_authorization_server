package tech.burny.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "security_interface")
public class SecurityInterface {

    @Id
    private Long id;

    private String name;

    private String key;
    private Integer sort;


}
