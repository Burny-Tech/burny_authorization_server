package tech.burny.security.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.burny.common.data.BaseController;
import tech.burny.security.entity.SecurityInterface;
import tech.burny.security.entity.SecurityMenu;

@RestController
@RequestMapping("sm")
@Tag(name = "菜单")


public class SecurityMenuController   extends BaseController<SecurityMenu> {





}
