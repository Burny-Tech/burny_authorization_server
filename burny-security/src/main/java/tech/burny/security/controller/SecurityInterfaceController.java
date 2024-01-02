package tech.burny.security.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.constructor.BaseConstructor;
import tech.burny.common.data.BaseController;
import tech.burny.security.entity.SecurityInterface;

@RequestMapping("si")
@RestController
@Tag(name = "接口")

public class SecurityInterfaceController extends BaseController<SecurityInterface> {



}
