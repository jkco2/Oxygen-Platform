package com.ethercraft.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "权限管理")
@Slf4j
@RestController
@RequestMapping("/api/permissions")
public class PermissionController {
}
