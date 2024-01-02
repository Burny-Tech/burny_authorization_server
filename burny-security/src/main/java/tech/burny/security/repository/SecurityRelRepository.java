package tech.burny.security.repository;

import io.swagger.v3.oas.annotations.media.SchemaProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;
import tech.burny.common.data.BaseRepository;
import tech.burny.security.entity.SecurityMenu;
import tech.burny.security.entity.rel.SecurityRel;

@Component
public interface SecurityRelRepository extends BaseRepository<SecurityRel> {


}
