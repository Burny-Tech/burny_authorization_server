package tech.burny.security.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.burny.common.data.BaseController;
import tech.burny.security.entity.SecurityInterface;
import tech.burny.security.entity.SecurityRole;

@RestController
@RequestMapping("sr")
@Tag(name = "角色")

public class SecurityRoleController  extends BaseController<SecurityRole> {

}
