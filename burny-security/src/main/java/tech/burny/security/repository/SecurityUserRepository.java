package tech.burny.security.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;
import tech.burny.common.data.BaseRepository;
import tech.burny.security.entity.SecurityMenu;
import tech.burny.security.entity.SecurityUser;

@Component
public interface SecurityUserRepository extends BaseRepository<SecurityUser> {


}
