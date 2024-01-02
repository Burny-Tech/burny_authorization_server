package tech.burny.security.entity.rel;

import io.swagger.v3.oas.annotations.media.SchemaProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "super_rel")
public class SecurityRel {
    @Id
    private Long id;

    private Long securityUserId;

    private Long securityRoleId;


    private Long  securityMenuId;

    private Long securityInterfaceId;


@SchemaProperty(name = "1 等等")
    private Long relType;

}
