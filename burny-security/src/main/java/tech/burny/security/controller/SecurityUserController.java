package tech.burny.security.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.burny.common.data.BaseController;
import tech.burny.security.entity.SecurityInterface;
import tech.burny.security.entity.SecurityUser;

@RestController
@RequestMapping("su")
@Tag(name = "权限用户")
public class SecurityUserController  extends BaseController<SecurityUser> {


}
